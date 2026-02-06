package com.aquarium.dto.fish;

public record FishDailyNutrientTotalDTO(
        Long id_fdn,
        Long id_nutrient,
        String nutrient,
        double qtt,
        double cur,
        double rest,
        double raceNeed,
        int subNb,
        double subWeight,
        double weightInc) {
}
