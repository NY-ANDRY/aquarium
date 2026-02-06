package com.aquarium.dto.aquarium;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AquariumFishDTO(
                Long id,
                String name,
                String speciesName,
                LocalDateTime date,
                BigDecimal weight) {

        public static AquariumFishDTO fromEntity(com.aquarium.models.tables.Fish fish) {
                if (fish == null) {
                        return null;
                }
                return new AquariumFishDTO(fish.getId(),
                                fish.getName(),
                                fish.getSpecies() != null ? fish.getSpecies().getName() : null,
                                fish.getCurDatetime(),
                                fish.getCurWeight());
        }

        public static List<AquariumFishDTO> toDTOList(List<com.aquarium.models.tables.Fish> fishes) {
                if (fishes == null) {
                        return List.of();
                }
                return fishes.stream().map(AquariumFishDTO::fromEntity).toList();
        }
}
