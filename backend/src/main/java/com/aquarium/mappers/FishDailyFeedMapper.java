package com.aquarium.mappers;

import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import com.aquarium.dto.FishDailyFeedDTO;
import com.aquarium.models.tables.FishDailyFeed;

@Component
@RequiredArgsConstructor
public class FishDailyFeedMapper {
    private final FishMapper fishMapper;

    public FishDailyFeedDTO toResponse(FishDailyFeed entity) {
        if (entity == null)
            return null;
        return new FishDailyFeedDTO(
                entity.getId(),
                entity.getIncreaseWeight(),
                // entity.getBeginWeight(),
                // entity.getEndWeight(),
                fishMapper.toResponse(entity.getFish()),
                entity.getDate());
    }
}
