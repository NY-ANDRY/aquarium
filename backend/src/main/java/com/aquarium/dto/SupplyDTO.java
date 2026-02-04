package com.aquarium.dto;

import java.time.LocalDateTime;

public record SupplyDTO(
                Long id,
                LocalDateTime begin,
                LocalDateTime end,
                AquariumDTO aquarium) {
}
