package com.aquarium.dto.aquarium;

import java.util.List;

public record AquariumDTO(
                Long id,
                String name,
                int nb_poisson) {

        public static AquariumDTO fromEntity(com.aquarium.models.tables.Aquarium aquarium) {
                if (aquarium == null) {
                        return null;
                }
                return new AquariumDTO(
                                aquarium.getId(),
                                aquarium.getName(),
                                aquarium.getFish() != null ? aquarium.getFish().size() : 0);
        }

        public static List<AquariumDTO> toDTOList(List<com.aquarium.models.tables.Aquarium> aquariums) {
                if (aquariums == null) {
                        return List.of();
                }
                return aquariums.stream().map(AquariumDTO::fromEntity).toList();
        }
}
