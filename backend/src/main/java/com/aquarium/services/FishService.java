package com.aquarium.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

import com.aquarium.repositories.FishRepository;
import com.aquarium.models.tables.Fish;
import com.aquarium.models.tables.FishDailyAliment;
import com.aquarium.models.tables.FishDailyFeed;
import com.aquarium.models.tables.FishDailyLog;
import com.aquarium.models.tables.FishDailyNutrient;
import com.aquarium.models.tables.Nutrient;
import com.aquarium.models.tables.Species;

@Service
@RequiredArgsConstructor
public class FishService {
    private final FishRepository repository;
    private final AlimentService alimentService;
    private final SpeciesService speciesService;
    private final FishDailyFeedService fishDailyFeedService;
    private final FishDailyAlimentService fishDailyAlimentService;
    private final FishDailyNutrientService fishDailyNutrientService;
    private final FishDailyLogService fishDailyLogService;

    public List<Fish> findAll() {
        return repository.findAll();
    }

    public Fish findById(Long id) {
        Fish result = repository.findById(id).orElse(null);
        double curWeight = weightTotal(result);
        result.setCurWeight(curWeight);
        return result;
    }

    public Fish findByIdAt(Long id, LocalDateTime date) {
        Fish result = findById(id);
        result.setCurDatetime(date);
        double curWeight = weightAt(result, date);
        result.setCurWeight(curWeight);
        return result;
    }

    public void processAndSave(FishDailyFeed fdf) {
        process(fdf);
        save(fdf);
        logFishDailyFeed(fdf);
    }

    public void process(FishDailyFeed fdf) {
        Fish fish = fdf.getFish();
        Species species = fish.getSpecies();
        List<FishDailyAliment> fdas = fdf.getFishDailyAliments();
        LocalDateTime datetime = fdf.getDate();

        for (FishDailyAliment fda : fdas) {
            alimentService.putNutriment(fda);
        }

        List<Nutrient> nutrients = speciesService.usedNutrients(species);
        double subIncWeight = species.getIncreaseCapacity() / nutrients.size();
        double increase_weight = 0;

        for (Nutrient nutrient : nutrients) {
            double newNutrientWeight = nutrientWeight(fdf, nutrient);
            double restNutrientWeight = restNutrientWeight(fish, nutrient, datetime);
            // System.out.println("-- " + restNutrientWeight);

            double nutrientWeight = newNutrientWeight + restNutrientWeight;

            double subQttDouble = nutrientWeight / speciesService.need(species, nutrient);
            int subQtt = (int) Math.floor(subQttDouble);

            double weightValue = subIncWeight * subQtt;

            increase_weight += weightValue;
        }

        fdf.setIncreaseWeight(increase_weight);
    }

    private void save(FishDailyFeed fdf) {
        fishDailyFeedService.save(fdf);
        for (FishDailyAliment fda : fdf.getFishDailyAliments()) {
            fishDailyAlimentService.save(fda);
            for (FishDailyNutrient fdn : fda.getFishDailyNutrient()) {
                fishDailyNutrientService.save(fdn);
            }
        }
    }

    private double restNutrientWeight(Fish fish, Nutrient nutrient, LocalDateTime datetime) {
        double result = 0;

        // List<FishDailyFeed> fdfs = fish.getFishDailyFeeds();
        List<FishDailyFeed> fdfs = fishDailyFeedService.findAllOf(fish);

        // System.out.println("-- fdfs size: " + fdfs.size());

        for (FishDailyFeed fdf : fdfs) {
            // System.out.println("-- " + fdf.getDate() + " is after " + datetime);
            if (fdf.getDate().isAfter(datetime))
                continue;
            result += nutrientWeight(fdf, nutrient);
        }
        Species species = fish.getSpecies();
        result = result % speciesService.need(species, nutrient);

        return result;
    }

    private double nutrientWeight(FishDailyFeed fdf, Nutrient nutrient) {
        double result = 0;

        for (FishDailyAliment fda : fdf.getFishDailyAliments()) {
            for (FishDailyNutrient fdn : fda.getFishDailyNutrient()) {
                if (fdn.getNutrient().equals(nutrient)) {
                    result += fdn.getQtt();
                }
            }
        }

        return result;
    }

    public boolean canEat(Fish fish, LocalDateTime today) {
        double weight = weightAt(fish, today);
        if (weight >= fish.getSpecies().getMaxWeight()) {
            return false;
        }
        return true;
    }

    public double weightTotal(Fish fish) {
        double result = fish.getInitialWeight();
        LocalDateTime firstDay = fish.getAquarium().getPeriod().getBegin();
        double incWeight = incWeightBetween(fish, firstDay, LocalDateTime.MAX);
        result += incWeight;
        return result;
    }

    public double weightAt(Fish fish, LocalDateTime dateTime) {
        double result = fish.getInitialWeight();
        LocalDateTime firstDay = fish.getAquarium().getPeriod().getBegin();
        double incWeight = incWeightBetween(fish, firstDay, dateTime);
        result += incWeight;
        return result;
    }

    public double incWeightBetween(Fish fish, LocalDateTime date1, LocalDateTime date2) {
        double result = 0;
        List<FishDailyFeed> fdfs = feedsBetween(fish, date1, date2);

        for (FishDailyFeed fishDailyFeed : fdfs) {
            result += fishDailyFeed.getIncreaseWeight();
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

    public void logFishDailyFeed(FishDailyFeed fdf) {
        FishDailyLog log = new FishDailyLog();

        LocalDateTime date = fdf.getDate();
        Fish fish = fdf.getFish();
        double increaseWeight = fdf.getIncreaseWeight();
        double endWeight = weightAt(fish, date);
        double beginWeight = endWeight - increaseWeight;

        log.setDate(date);
        log.setFish(fish);
        log.setIncreaseWeight(increaseWeight);
        log.setBeginWeight(beginWeight);
        log.setEndWeight(endWeight);

        fishDailyLogService.save(log);
    }

    public double expense(Fish fish) {
        double result = 0;
        Species species = fish.getSpecies();
        result += fish.getInitialWeight() * species.getPurchasePrice();
        return result;
    }

    public double income(Fish fish, LocalDateTime datetime) {
        double result = 0;
        Species species = fish.getSpecies();

        double weight = weightAt(fish, datetime);
        result += species.getSalePrice() * weight;

        return result;
    }
}
