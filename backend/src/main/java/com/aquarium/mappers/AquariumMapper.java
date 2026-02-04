package com.aquarium.mappers;

import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import com.aquarium.dto.AquariumDTO;
import com.aquarium.models.tables.Aquarium;

@Component
@RequiredArgsConstructor
public class AquariumMapper {
    private final PeriodMapper periodMapper;

    public AquariumDTO toResponse(Aquarium entity) {
        if (entity == null)
            return null;
        return new AquariumDTO(
                entity.getId(),
                entity.getName(),
                periodMapper.toResponse(entity.getPeriod()));
    }
}
