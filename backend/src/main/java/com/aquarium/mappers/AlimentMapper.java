package com.aquarium.mappers;

import org.springframework.stereotype.Component;
import com.aquarium.dto.AlimentDTO;
import com.aquarium.models.tables.Aliment;

@Component
public class AlimentMapper {

    public AlimentDTO toResponse(Aliment entity) {
        if (entity == null)
            return null;
        return new AlimentDTO(
                entity.getId(),
                entity.getName(),
                entity.getCost());
    }
}
