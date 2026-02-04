package com.aquarium.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.aquarium.models.tables.Aquarium;
import com.aquarium.models.tables.Feed;
import com.aquarium.models.tables.Fish;
import com.aquarium.models.tables.Period;
import com.aquarium.models.tables.Supply;
import com.aquarium.repositories.PeriodRepository;

@Service
@RequiredArgsConstructor
public class PeriodService {
    private final PeriodRepository repository;
    private final SupplyService supplyService;
    // private int test = 0;

    public List<Period> findAll() {
        return repository.findAll();
    }

    public Period findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void process(Period p, LocalDateTime end_datetime) {
        LocalDateTime curDateTime = p.getBegin();

        while (!curDateTime.isAfter(end_datetime)) {
            System.out.println("");
            System.out.println("- " + curDateTime + "  ");
            System.out.println("");

            processDay(p, curDateTime);
            curDateTime = curDateTime.plusDays(1);
        }
    }

    public void processDay(Period p, LocalDateTime datetime) {
        List<Aquarium> aquariums = p.getAquariums();

        for (Aquarium aquarium : aquariums) {
            dailyFeed(aquarium, datetime);
        }
    }

    public void dailyFeed(Aquarium aquarium, LocalDateTime datetime) {
        List<Fish> fish = aquarium.getFish();
        List<Supply> supplies = aquarium.getSupplies();
        List<Feed> feeds = takeFeedsAt(supplies, datetime);

        supplyService.shareAndFeed(fish, feeds, datetime);
    }

    public List<Feed> takeFeedsAt(List<Supply> supplies, LocalDateTime datetime) {
        LocalDate date = datetime.toLocalDate();

        for (Supply supply : supplies) {
            LocalDate firstDay = supply.getBegin().toLocalDate();
            LocalDate lastDay = supply.getEnd().toLocalDate();

            if (!date.isBefore(firstDay) && !date.isAfter(lastDay)) {
                return supply.getFeeds();
            }
        }

        return new ArrayList<Feed>();
    }
}
