package com.aquarium.mappers;

import org.springframework.stereotype.Component;
import com.aquarium.dto.FlowDTO;
import com.aquarium.models.tables.Flow;

@Component
public class FlowMapper {

    public FlowDTO toResponse(Flow entity) {
        if (entity == null)
            return null;
        return new FlowDTO(
                entity.getId(),
                entity.getDescription(),
                entity.getFlow());
    }
}
