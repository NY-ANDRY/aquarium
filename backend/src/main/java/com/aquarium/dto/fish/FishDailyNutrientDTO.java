package com.aquarium.dto.fish;

public record FishDailyNutrientDTO(
        Long id_fdn,
        Long id_nutrient,
        String nutrient,
        double qtt) {
}
