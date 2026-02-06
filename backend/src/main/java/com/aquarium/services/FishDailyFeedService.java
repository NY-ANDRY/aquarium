package com.aquarium.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

import com.aquarium.repositories.FishDailyFeedRepository;
import com.aquarium.models.logics.NutrientQtt;
import com.aquarium.models.tables.Fish;
import com.aquarium.models.tables.FishDailyAliment;
import com.aquarium.models.tables.FishDailyFeed;
import com.aquarium.models.tables.FishDailyNutrient;
import com.aquarium.models.tables.Nutrient;
import com.aquarium.models.tables.Species;

@Service
@RequiredArgsConstructor
public class FishDailyFeedService {
    private final FishDailyFeedRepository repository;
    private final FishDailyAlimentService fishDailyAlimentService;
    private final SpeciesService speciesService;

    public List<FishDailyFeed> findAll() {
        return repository.findAll();
    }

    public FishDailyFeed findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public FishDailyFeed save(FishDailyFeed fdf) {
        FishDailyFeed result = repository.save(fdf);
        for (FishDailyAliment fda : fdf.getFishDailyAliments()) {
            fishDailyAlimentService.save(fda);
        }
        return result;
    }

    public List<FishDailyFeed> findAllOf(Fish f) {
        return repository.findByFishId(f.getId());
    }

    public List<FishDailyFeed> betweenOf(Fish fish, LocalDateTime date1, LocalDateTime date2) {
        return repository.findByFishIdBetween(fish.getId(), date1, date2);
    }

    public BigDecimal nutrientWeight(FishDailyFeed fdf, Nutrient nutrient) {
        BigDecimal result = BigDecimal.ZERO;

        for (FishDailyAliment fda : fdf.getFishDailyAliments()) {
            for (FishDailyNutrient fdn : fda.getFishDailyNutrient()) {
                if (fdn.getNutrient().equals(nutrient)) {
                    result = result.add(fdn.getQtt());
                }
            }
        }

        return result;
    }

    public BigDecimal restNutrientWeight(Fish fish, Nutrient nutrient, LocalDateTime datetime) {
        Species species = fish.getSpecies();
        List<FishDailyFeed> fdfs = findAllOf(fish);

        BigDecimal result = BigDecimal.ZERO;

        for (FishDailyFeed fdf : fdfs) {
            if (!fdf.getDate().isBefore(datetime))
                continue;

            result = result.add(nutrientWeight(fdf, nutrient));
        }

        BigDecimal need = speciesService.need(species, nutrient);

        result = result.remainder(need).setScale(3, RoundingMode.HALF_UP);

        return result;
    }

    public List<NutrientQtt> nutrientsQtt(FishDailyFeed fdf) {
        List<NutrientQtt> result = new ArrayList<NutrientQtt>();
        Fish fish = fdf.getFish();
        Species species = fish.getSpecies();

        List<Nutrient> nutrients = speciesService.usedNutrients(species);
        LocalDateTime datetime = fdf.getDate();

        BigDecimal subIncWeight = species.getIncreaseCapacity().divide(BigDecimal.valueOf(nutrients.size()));

        for (Nutrient nutrient : nutrients) {
            NutrientQtt nq = new NutrientQtt();
            nq.setNutrient(nutrient);

            BigDecimal cur = nutrientWeight(fdf, nutrient);
            BigDecimal rest = restNutrientWeight(fish, nutrient, datetime);
            BigDecimal qtt = cur.add(rest);

            BigDecimal need = speciesService.need(species, nutrient);
            BigDecimal subQttDouble = qtt.divide(need);
            // int subQtt = (int) Math.floor(subQttDouble);
            BigDecimal subQtt = subQttDouble.setScale(0, RoundingMode.FLOOR);

            nq.setRaceNeed(need);
            nq.setSubNb(subQtt);
            nq.setSubWeight(subIncWeight);
            nq.setWeightInc(subIncWeight.multiply(subQtt));

            nq.setCur(cur);
            nq.setRest(rest);
            nq.setQtt(qtt);

            result.add(nq);
        }

        return result;
    }
}
