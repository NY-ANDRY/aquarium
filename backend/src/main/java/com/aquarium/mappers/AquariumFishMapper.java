package com.aquarium.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.aquarium.dto.aquarium.AquariumFishDTO;
import com.aquarium.models.tables.Fish;

@Component
public class AquariumFishMapper {

    public AquariumFishDTO toDTO(Fish fish) {
        if (fish == null) {
            return null;
        }
        return new AquariumFishDTO(fish.getId(), fish.getName(), fish.getSpecies().getName(), fish.getCurDatetime(),
                fish.getCurWeight());
    }

    public Fish toEntity(AquariumFishDTO dto) {
        if (dto == null) {
            return null;
        }
        Fish fish = new Fish();
        fish.setId(dto.id());
        fish.setName(dto.name());
        return fish;
    }

    public List<AquariumFishDTO> toDTOList(List<Fish> aquariums) {
        if (aquariums == null) {
            return null;
        }
        return aquariums.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
