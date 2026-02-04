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
import com.aquarium.models.tables.Race;

@Service
@RequiredArgsConstructor
public class FishService {
    private final FishRepository repository;
    private final AlimentService alimentService;
    private final RaceService raceService;
    private final FishDailyFeedService fishDailyFeedService;
    private final FishDailyAlimentService fishDailyAlimentService;
    private final FishDailyNutrientService fishDailyNutrientService;
    private final FishDailyLogService fishDailyLogService;

    public List<Fish> findAll() {
        return repository.findAll();
    }

    public Fish findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void processAndLog(FishDailyFeed fdf) {
        process(fdf);
        logFishDailyFeed(fdf);
    }

    public void process(FishDailyFeed fdf) {
        Fish fish = fdf.getFish();
        Race race = fish.getRace();
        List<FishDailyAliment> fdas = fdf.getFishDailyAliments();
        LocalDateTime datetime = fdf.getDate();

        for (FishDailyAliment fda : fdas) {
            alimentService.putNutriment(fda);
        }

        List<Nutrient> nutrients = raceService.usedNutrients(race);
        double subIncWeight = race.getIncreaseCapacity() / nutrients.size();
        double increase_weight = 0;

        for (Nutrient nutrient : nutrients) {
            double newNutrientWeight = nutrientWeight(fdf, nutrient);
            double restNutrientWeight = restNutrientWeight(fish, nutrient, datetime);

            double nutrientWeight = newNutrientWeight + restNutrientWeight;

            double subQttDouble = nutrientWeight / raceService.need(race, nutrient);
            int subQtt = (int) Math.floor(subQttDouble);

            double weightValue = subIncWeight * subQtt;

            increase_weight += weightValue;
        }

        fdf.setIncreaseWeight(increase_weight);

        save(fdf);
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

        List<FishDailyFeed> fdfs = fish.getFishDailyFeeds();

        for (FishDailyFeed fdf : fdfs) {
            if (fdf.getDate().isAfter(datetime))
                continue;
            result += nutrientWeight(fdf, nutrient);
        }
        Race race = fish.getRace();
        result = result % raceService.need(race, nutrient);

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
        if (weight >= fish.getRace().getMaxWeight()) {
            return false;
        }
        return true;
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
}
