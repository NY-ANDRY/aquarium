package com.aquarium.dto.period;

import java.time.LocalDateTime;

public record PeriodCreationDTO(
        String name,
        LocalDateTime begin) {
}
