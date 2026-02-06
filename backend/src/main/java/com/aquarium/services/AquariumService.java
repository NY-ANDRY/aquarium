package com.aquarium.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public BigDecimal expense(Aquarium aquarium, LocalDateTime datetime) {
        BigDecimal result = BigDecimal.ZERO;

        List<Fish> fish = aquarium.getFish();

        for (Fish f : fish) {
            result = result.add(fishService.expense(f));
        }

        List<Supply> supplies = aquarium.getSupplies();

        for (Supply supply : supplies) {
            if (datetime != null && supply.getEnd().isAfter(datetime)) {
                continue;
            }
            result = result.add(supplyService.expense(supply, datetime));
        }

        return result;
    }

    public BigDecimal income(Aquarium aquarium, LocalDateTime datetime) {
        BigDecimal result = BigDecimal.ZERO;

        List<Fish> fish = aquarium.getFish();

        for (Fish f : fish) {
            result = result.add(fishService.income(f, datetime));
        }

        return result;
    }
}
