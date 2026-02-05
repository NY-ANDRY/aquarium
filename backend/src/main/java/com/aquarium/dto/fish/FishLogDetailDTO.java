package com.aquarium.dto.fish;

import java.time.LocalDateTime;

public record FishLogDetailDTO(
                LocalDateTime date,
                double weight) {
}
