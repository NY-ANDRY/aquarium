package com.aquarium.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.aquarium.dto.fish.FishDTO;
import com.aquarium.models.tables.Fish;

@Component
public class FishMapper {

    public FishDTO toDTO(Fish fish) {
        if (fish == null) {
            return null;
        }
        return new FishDTO(fish.getId(), fish.getName(), fish.getCurDatetime(), fish.getCurWeight());
    }

    public FishDTO logToDTO(Fish fish) {
        if (fish == null) {
            return null;
        }
        return new FishDTO(fish.getId(), fish.getName(), fish.getCurDatetime(), fish.getCurWeight());
    }

    public Fish toEntity(FishDTO dto) {
        if (dto == null) {
            return null;
        }
        Fish fish = new Fish();
        fish.setId(dto.id());
        fish.setName(dto.name());
        return fish;
    }

    public List<FishDTO> toDTOList(List<Fish> aquariums) {
        if (aquariums == null) {
            return null;
        }
        return aquariums.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
