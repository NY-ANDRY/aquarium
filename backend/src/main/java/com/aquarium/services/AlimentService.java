package com.aquarium.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.AlimentRepository;
import com.aquarium.models.tables.Aliment;
import com.aquarium.models.tables.AlimentNutrient;
import com.aquarium.models.tables.FishDailyAliment;
import com.aquarium.models.tables.FishDailyNutrient;
import com.aquarium.models.tables.Nutrient;

@Service
@RequiredArgsConstructor
public class AlimentService {
    private final AlimentRepository repository;

    public List<Aliment> findAll() {
        return repository.findAll();
    }

    public Aliment findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void putNutriment(FishDailyAliment fda) {
        List<FishDailyNutrient> result = new ArrayList<FishDailyNutrient>();

        Aliment aliment = fda.getAliment();
        List<Nutrient> nutrients = usedNutrients(fda.getAliment());

        for (Nutrient nutrient : nutrients) {
            FishDailyNutrient fdn = new FishDailyNutrient();
            fdn.setFishDailyAliment(fda);
            fdn.setNutrient(nutrient);

            BigDecimal intake = intake(aliment, nutrient);
            BigDecimal nutrientQtt = intake.multiply(fda.getQtt());

            fdn.setQtt(nutrientQtt);
            result.add(fdn);
        }

        fda.setFishDailyNutrient(result);
    }

    public BigDecimal intake(Aliment aliment, Nutrient Nutrient) {
        for (AlimentNutrient an : aliment.getAlimentNutrients()) {
            if (an.getNutrient().equals(Nutrient)) {
                return an.getIntake();
            }
        }
        return BigDecimal.ZERO;
    }

    public List<Nutrient> usedNutrients(Aliment aliment) {
        return aliment.getAlimentNutrients().stream().map(el -> el.getNutrient()).toList();
    }
}
