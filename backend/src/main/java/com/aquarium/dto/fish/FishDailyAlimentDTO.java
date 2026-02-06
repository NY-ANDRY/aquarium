package com.aquarium.dto.fish;

import java.math.BigDecimal;
import java.util.List;

public record FishDailyAlimentDTO(
        Long id_fdf,
        Long id_aliment,
        String aliment,
        BigDecimal qtt,
        List<FishDailyNutrientDTO> fdns) {

    public static FishDailyAlimentDTO fromEntity(com.aquarium.models.tables.FishDailyAliment fda) {
        if (fda == null) {
            return null;
        }
        return new FishDailyAlimentDTO(fda.getId(), fda.getAliment().getId(), fda.getAliment().getName(), fda.getQtt(),
                fda.getFishDailyNutrient().stream().map(FishDailyNutrientDTO::fromEntity).toList());
    }

    public static List<FishDailyAlimentDTO> toDTOList(List<com.aquarium.models.tables.FishDailyAliment> fdas) {
        if (fdas == null) {
            return List.of();
        }
        return fdas.stream().map(FishDailyAlimentDTO::fromEntity).toList();
    }
}
