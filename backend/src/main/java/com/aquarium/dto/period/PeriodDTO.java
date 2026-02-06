package com.aquarium.dto.period;

import java.util.List;

import java.time.LocalDateTime;

public record PeriodDTO(
                Long id,
                String name,
                LocalDateTime begin,
                LocalDateTime end) {

        public static PeriodDTO fromEntity(com.aquarium.models.tables.Period period) {
                if (period == null) {
                        return null;
                }
                return new PeriodDTO(
                                period.getId(),
                                period.getName(),
                                period.getBegin(),
                                period.getEnd());
        }

        public static List<PeriodDTO> toDTOList(List<com.aquarium.models.tables.Period> periods) {
                if (periods == null) {
                        return List.of();
                }
                return periods.stream().map(PeriodDTO::fromEntity).toList();
        }
}
