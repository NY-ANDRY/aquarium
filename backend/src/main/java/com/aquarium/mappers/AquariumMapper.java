package com.aquarium.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.aquarium.dto.aquarium.AquariumDTO;
import com.aquarium.models.tables.Aquarium;

@Component
public class AquariumMapper {

    public AquariumDTO toDTO(Aquarium aquarium) {
        if (aquarium == null) {
            return null;
        }
        return new AquariumDTO(
                aquarium.getId(),
                aquarium.getName(),
                aquarium.getFish().size());
    }

    public Aquarium toEntity(AquariumDTO dto) {
        if (dto == null) {
            return null;
        }
        Aquarium aquarium = new Aquarium();
        aquarium.setId(dto.id());
        aquarium.setName(dto.name());
        return aquarium;
    }

    public List<AquariumDTO> toDTOList(List<Aquarium> aquariums) {
        if (aquariums == null) {
            return null;
        }
        return aquariums.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
