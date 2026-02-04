package com.aquarium.mappers;

import org.springframework.stereotype.Component;
import com.aquarium.dto.RaceDTO;
import com.aquarium.models.tables.Race;

@Component
public class RaceMapper {

    public RaceDTO toResponse(Race entity) {
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
