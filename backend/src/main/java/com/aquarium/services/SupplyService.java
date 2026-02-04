package com.aquarium.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.SupplyRepository;
import com.aquarium.models.tables.Feed;
import com.aquarium.models.tables.Fish;
import com.aquarium.models.tables.FishDailyAliment;
import com.aquarium.models.tables.FishDailyFeed;
import com.aquarium.models.tables.Supply;

@Service
@RequiredArgsConstructor
public class SupplyService {
    private final SupplyRepository repository;
    private final FishService fishService;

    public List<Supply> findAll() {
        return repository.findAll();
    }

    public Supply findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void shareAndFeed(List<Fish> fish, List<Feed> feeds, LocalDateTime date) {
        List<FishDailyFeed> fdf = share(fish, feeds, date);
        for (FishDailyFeed fishDailyFeed : fdf) {
            fishService.processAndLog(fishDailyFeed);
        }
    }

    public List<FishDailyFeed> share(List<Fish> fish, List<Feed> feed, LocalDateTime date) {
        List<FishDailyFeed> result = new ArrayList<FishDailyFeed>();

        List<Fish> readyFish = readyFish(fish, date);

        Map<Feed, Double> feedQtt = new HashMap<Feed, Double>();

        for (Feed f : feed) {
            double individualAmount = f.getQtt() / readyFish.size();
            feedQtt.putIfAbsent(f, individualAmount);
        }

        for (Fish f : readyFish) {
            FishDailyFeed fdf = new FishDailyFeed();
            fdf.setFish(f);
            fdf.setDate(date);
            List<FishDailyAliment> fdas = new ArrayList<FishDailyAliment>();
            feedQtt.forEach((fee, q) -> {
                FishDailyAliment fda = new FishDailyAliment();
                fda.setFishDailyFeed(fdf);
                fda.setAliment(fee.getAliment());
                fda.setQtt(q);
                fdas.add(fda);
            });
            fdf.setFishDailyAliments(fdas);

            result.add(fdf);
        }

        return result;
    }

    private List<Fish> readyFish(List<Fish> fish, LocalDateTime date) {
        List<Fish> result = new ArrayList<Fish>();

        for (Fish f : fish) {
            if (!fishService.canEat(f, date)) {
                continue;
            }
            result.add(f);
        }

        return result;
    }
}
