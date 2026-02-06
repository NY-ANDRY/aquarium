package com.aquarium.dto.fish;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FishDTO(
                Long id,
                String name,
                LocalDateTime date,
                BigDecimal weight,
                BigDecimal initial_weight) {

        public static FishDTO fromEntity(com.aquarium.models.tables.Fish fish) {
                if (fish == null) {
                        return null;
                }
                return new FishDTO(fish.getId(), fish.getName(), fish.getCurDatetime(), fish.getCurWeight(),
                                fish.getInitialWeight());
        }

        public static List<FishDTO> toDTOList(List<com.aquarium.models.tables.Fish> fishes) {
                if (fishes == null) {
                        return List.of();
                }
                return fishes.stream().map(FishDTO::fromEntity).toList();
        }
}
