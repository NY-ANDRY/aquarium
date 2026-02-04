package com.aquarium.mappers;

import org.springframework.stereotype.Component;
import com.aquarium.dto.NutrientDTO;
import com.aquarium.models.tables.Nutrient;

@Component
public class NutrientMapper {

    public NutrientDTO toResponse(Nutrient entity) {
        if (entity == null)
            return null;
        return new NutrientDTO(
                entity.getId(),
                entity.getName(),
                entity.getImg());
    }
}
