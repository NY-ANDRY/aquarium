package com.aquarium.dto.period;

import java.time.LocalDateTime;

public record PeriodDTO(
        Long id,
        String name,
        LocalDateTime begin,
        LocalDateTime end) {
}
