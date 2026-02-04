package com.aquarium.mappers;

import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import com.aquarium.dto.SupplyDTO;
import com.aquarium.models.tables.Supply;

@Component
@RequiredArgsConstructor
public class SupplyMapper {
    private final AquariumMapper aquariumMapper;

    public SupplyDTO toResponse(Supply entity) {
        if (entity == null)
            return null;
        return new SupplyDTO(
                entity.getId(),
                entity.getBegin(),
                entity.getEnd(),
                aquariumMapper.toResponse(entity.getAquarium()));
    }
}
