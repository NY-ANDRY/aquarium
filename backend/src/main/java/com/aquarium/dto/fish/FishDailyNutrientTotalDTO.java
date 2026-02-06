package com.aquarium.dto.fish;

import java.math.BigDecimal;
import java.util.List;

public record FishDailyNutrientTotalDTO(
                Long id_fdn,
                Long id_nutrient,
                String nutrient,
                BigDecimal qtt,
                BigDecimal cur,
                BigDecimal rest,
                BigDecimal raceNeed,
                BigDecimal subNb,
                BigDecimal subWeight,
                BigDecimal weightInc) {

        public static FishDailyNutrientTotalDTO fromLogic(com.aquarium.models.helpers.NutrientQtt nq) {
                if (nq == null) {
                        return null;
                }
                return new FishDailyNutrientTotalDTO(null, nq.getNutrient().getId(), nq.getNutrient().getName(),
                                nq.getQtt(), nq.getCur(), nq.getRest(), nq.getRaceNeed(), nq.getSubNb(),
                                nq.getSubWeight(),
                                nq.getWeightInc());
        }

        public static List<FishDailyNutrientTotalDTO> toDTOList(List<com.aquarium.models.helpers.NutrientQtt> nqs) {
                if (nqs == null) {
                        return List.of();
                }
                return nqs.stream().map(FishDailyNutrientTotalDTO::fromLogic).toList();
        }
}
