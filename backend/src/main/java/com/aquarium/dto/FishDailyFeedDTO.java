package com.aquarium.dto;

import java.time.LocalDateTime;

public record FishDailyFeedDTO(
                Long id,
                double increase,
                // double beginWeight,
                // double endWeight,
                FishDTO fish,
                LocalDateTime date) {
}
