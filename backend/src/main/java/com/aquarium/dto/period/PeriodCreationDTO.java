package com.aquarium.dto.period;

import java.time.LocalDateTime;

public record PeriodCreationDTO(
                String name,
                LocalDateTime begin) {
        public com.aquarium.models.tables.Period toEntity() {
                com.aquarium.models.tables.Period period = new com.aquarium.models.tables.Period();
                period.setName(this.name());
                period.setBegin(this.begin());
                return period;
        }
}
