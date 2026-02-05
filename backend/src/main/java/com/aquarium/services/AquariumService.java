package com.aquarium.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.AquariumRepository;
import com.aquarium.models.tables.Aquarium;
import com.aquarium.models.tables.Fish;
import com.aquarium.models.tables.Supply;

@Service
@RequiredArgsConstructor
public class AquariumService {
    private final AquariumRepository repository;
    private final FishService fishService;
    private final SupplyService supplyService;

    public List<Aquarium> findAll() {
        return repository.findAll();
    }

    public Aquarium findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public double expense(Aquarium aquarium, LocalDateTime datetime) {
        double result = 0;

        List<Fish> fish = aquarium.getFish();

        for (Fish f : fish) {
            result += fishService.expense(f);
        }

        List<Supply> supplies = aquarium.getSupplies();

        for (Supply supply : supplies) {
            if (datetime != null && supply.getEnd().isAfter(datetime)) {
                continue;
            }
            result += supplyService.expense(supply, datetime);
        }

        return result;
    }

    public double income(Aquarium aquarium, LocalDateTime datetime) {
        double result = 0;

        List<Fish> fish = aquarium.getFish();

        for (Fish f : fish) {
            result += fishService.income(f, datetime);
        }

        return result;
    }
}
