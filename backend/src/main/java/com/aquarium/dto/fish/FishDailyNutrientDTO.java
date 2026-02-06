package com.aquarium.dto.fish;

import java.math.BigDecimal;
import java.util.List;

public record FishDailyNutrientDTO(
                Long id_fdn,
                Long id_nutrient,
                String nutrient,
                BigDecimal qtt) {

        public static FishDailyNutrientDTO fromEntity(com.aquarium.models.tables.FishDailyNutrient fdn) {
                if (fdn == null) {
                        return null;
                }
                return new FishDailyNutrientDTO(fdn.getId(), fdn.getNutrient().getId(), fdn.getNutrient().getName(),
                                fdn.getQtt());
        }

        public static List<FishDailyNutrientDTO> toDTOList(List<com.aquarium.models.tables.FishDailyNutrient> fdns) {
                if (fdns == null) {
                        return List.of();
                }
                return fdns.stream().map(FishDailyNutrientDTO::fromEntity).toList();
        }
}
