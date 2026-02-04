package com.aquarium.dto;

public record FishDTO(
                Long id,
                String name,
                double initialWeight,
                RaceDTO race,
                AquariumDTO aquarium) {
}
