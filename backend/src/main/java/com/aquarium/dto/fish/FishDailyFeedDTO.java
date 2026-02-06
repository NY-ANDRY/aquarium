package com.aquarium.dto.fish;

import java.time.LocalDateTime;

public record FishDailyFeedDTO(
        Long id_fdf,
        LocalDateTime date,
        double weight,
        double increase) {
}
