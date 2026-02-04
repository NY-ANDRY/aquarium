package com.aquarium.mappers;

import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import com.aquarium.dto.FishDTO;
import com.aquarium.models.tables.Fish;

@Component
@RequiredArgsConstructor
public class FishMapper {
    private final RaceMapper raceMapper;
    private final AquariumMapper aquariumMapper;

    public FishDTO toResponse(Fish entity) {
        if (entity == null)
            return null;
        return new FishDTO(
                entity.getId(),
                entity.getName(),
                entity.getInitialWeight(),
                raceMapper.toResponse(entity.getSpecies()),
                aquariumMapper.toResponse(entity.getAquarium()));
    }
}
