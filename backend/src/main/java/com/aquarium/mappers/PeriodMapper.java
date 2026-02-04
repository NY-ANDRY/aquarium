package com.aquarium.mappers;

import org.springframework.stereotype.Component;
import com.aquarium.dto.PeriodDTO;
import com.aquarium.models.tables.Period;

@Component
public class PeriodMapper {

    public PeriodDTO toResponse(Period entity) {
        if (entity == null)
            return null;
        return new PeriodDTO(
                entity.getId(),
                entity.getName(),
                entity.getBegin(),
                entity.getEnd());
    }
}
