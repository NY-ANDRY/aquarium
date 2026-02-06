package com.aquarium.dto.fish;

import java.util.List;

public record FishDailyAlimentDTO(
                Long id_fdf,
                Long id_aliment,
                String aliment,
                double qtt,
                List<FishDailyNutrientDTO> fdns) {
}
