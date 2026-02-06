package com.aquarium.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

import com.aquarium.repositories.FishRepository;
import com.aquarium.models.tables.Fish;
import com.aquarium.models.tables.FishDailyAliment;
import com.aquarium.models.tables.FishDailyFeed;
import com.aquarium.models.tables.Nutrient;
import com.aquarium.models.tables.Species;

@Service
@RequiredArgsConstructor
public class FishService {
    private final FishRepository repository;
    private final AlimentService alimentService;
    private final SpeciesService speciesService;
    private final FishDailyFeedService fishDailyFeedService;

    public List<Fish> findAll() {
        return repository.findAll();
    }

    public Fish findById(Long id) {
        Fish result = repository.findById(id).orElse(null);
        BigDecimal curWeight = weightTotal(result);
        result.setCurWeight(curWeight);
        return result;
    }

    public Fish findByIdAt(Long id, LocalDateTime date) {
        Fish result = findById(id);
        result.setCurDatetime(date);
        BigDecimal curWeight = weightAt(result, date);
        result.setCurWeight(curWeight);
        return result;
    }

    public void processAndSave(FishDailyFeed fdf) {
        List<FishDailyAliment> fdas = fdf.getFishDailyAliments();

        for (FishDailyAliment fda : fdas) {
            alimentService.putNutriment(fda);
        }

        eat(fdf);
        fishDailyFeedService.save(fdf);
    }

    private void eat(FishDailyFeed fdf) {
        Fish fish = fdf.getFish();
        Species species = fish.getSpecies();
        LocalDateTime datetime = fdf.getDate();

        List<Nutrient> nutrients = speciesService.usedNutrients(species);
        BigDecimal subIncWeight = species.getIncreaseCapacity().divide(BigDecimal.valueOf(nutrients.size()));
        BigDecimal increase_weight = BigDecimal.ZERO;

        BigDecimal curWeight = weightTotal(fish);
        BigDecimal max_weight = species.getMaxWeight();
        BigDecimal max_increase = max_weight.subtract(curWeight);

        for (Nutrient nutrient : nutrients) {
            BigDecimal newNutrientWeight = fishDailyFeedService.nutrientWeight(fdf, nutrient);
            BigDecimal restNutrientWeight = fishDailyFeedService.restNutrientWeight(fish, nutrient, datetime);

            BigDecimal nutrientWeight = newNutrientWeight.add(restNutrientWeight);
            BigDecimal need = speciesService.need(species, nutrient);

            BigDecimal subQttDouble = nutrientWeight.divide(need);
            BigDecimal subQtt = subQttDouble.setScale(0, RoundingMode.FLOOR);

            BigDecimal weightValue = subIncWeight.multiply(subQtt);

            increase_weight = increase_weight.add(weightValue);
            if (increase_weight.compareTo(max_increase) >= 0) {
                increase_weight = max_increase;
                break;
            }
        }

        curWeight = curWeight.add(increase_weight);
        fdf.setCurWeight(curWeight);
        fdf.setIncreaseWeight(increase_weight);
    }

    // private BigDecimal restNutrientWeight(Fish fish, Nutrient nutrient,
    // LocalDateTime
    // datetime) {
    // BigDecimal result = 0;

    // List<FishDailyFeed> fdfs = fishDailyFeedService.findAllOf(fish);

    // for (FishDailyFeed fdf : fdfs) {
    // if (fdf.getDate().isAfter(datetime))
    // continue;
    // result += fishDailyFeedService.nutrientWeight(fdf, nutrient);
    // }
    // Species species = fish.getSpecies();
    // result = result % speciesService.need(species, nutrient);

    // return result;
    // }

    // public BigDecimal nutrientWeight(FishDailyFeed fdf, Nutrient nutrient) {
    // BigDecimal result = 0;

    // for (FishDailyAliment fda : fdf.getFishDailyAliments()) {
    // for (FishDailyNutrient fdn : fda.getFishDailyNutrient()) {
    // if (fdn.getNutrient().equals(nutrient)) {
    // result += fdn.getQtt();
    // }
    // }
    // }

    // return result;
    // }

    public boolean canEat(Fish fish, LocalDateTime today) {
        BigDecimal weight = weightAt(fish, today);
        if (weight.compareTo(fish.getSpecies().getMaxWeight()) >= 0) {
            return false;
        }
        return true;
    }

    public BigDecimal weightTotal(Fish fish) {
        BigDecimal result = fish.getInitialWeight();
        BigDecimal incWeight = incWeightTotal(fish);
        result = result.add(incWeight);
        return result;
    }

    public BigDecimal weightAt(Fish fish, LocalDateTime dateTime) {
        BigDecimal result = fish.getInitialWeight();
        LocalDateTime firstDay = fish.getAquarium().getPeriod().getBegin();
        BigDecimal incWeight = incWeightBetween(fish, firstDay, dateTime);
        result = result.add(incWeight);
        return result;
    }

    public BigDecimal incWeightTotal(Fish fish) {
        BigDecimal result = BigDecimal.ZERO;
        List<FishDailyFeed> fdfs = fishDailyFeedService.findAllOf(fish);

        for (FishDailyFeed fishDailyFeed : fdfs) {
            result = result.add(fishDailyFeed.getIncreaseWeight());
        }

        return result;
    }

    public BigDecimal incWeightBetween(Fish fish, LocalDateTime date1, LocalDateTime date2) {
        BigDecimal result = BigDecimal.ZERO;
        List<FishDailyFeed> fdfs = fishDailyFeedService.betweenOf(fish, date1, date2);

        for (FishDailyFeed fishDailyFeed : fdfs) {
            result = result.add(fishDailyFeed.getIncreaseWeight());
        }

        return result;
    }

    public List<FishDailyFeed> feedsBetween(Fish fish, LocalDateTime date1, LocalDateTime date2) {
        List<FishDailyFeed> result = new ArrayList<FishDailyFeed>();
        List<FishDailyFeed> fdfs = fish.getFishDailyFeeds();

        for (FishDailyFeed fishDailyFeed : fdfs) {
            LocalDateTime feedDate = fishDailyFeed.getDate();
            if (!feedDate.isBefore(date1) && !feedDate.isAfter(date2)) {
                result.add(fishDailyFeed);
            }
        }
        return result;
    }

    public BigDecimal expense(Fish fish) {
        BigDecimal result = BigDecimal.ZERO;
        Species species = fish.getSpecies();
        result = result.add(fish.getInitialWeight().multiply(species.getPurchasePrice()));
        return result;
    }

    public BigDecimal income(Fish fish, LocalDateTime datetime) {
        BigDecimal result = BigDecimal.ZERO;
        Species species = fish.getSpecies();

        BigDecimal weight = weightAt(fish, datetime);
        result = result.add(species.getSalePrice().multiply(weight));

        return result;
    }
}
