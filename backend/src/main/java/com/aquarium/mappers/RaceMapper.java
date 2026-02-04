package com.aquarium.mappers;

import org.springframework.stereotype.Component;
import com.aquarium.dto.RaceDTO;
import com.aquarium.models.tables.Species;

@Component
public class RaceMapper {

    public RaceDTO toResponse(Species entity) {
        if (entity == null)
            return null;
        return new RaceDTO(
                entity.getId(),
                entity.getName(),
                entity.getPurchasePrice(),
                entity.getSalePrice(),
                entity.getMaxWeight(),
                entity.getIncreaseCapacity());
    }
}
