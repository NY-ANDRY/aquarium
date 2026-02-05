package com.aquarium.dto.fish;

import java.time.LocalDateTime;

public record FishDTO(
                Long id,
                String name,
                LocalDateTime date,
                double weight) {
}
