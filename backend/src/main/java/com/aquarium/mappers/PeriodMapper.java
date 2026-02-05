package com.aquarium.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.aquarium.dto.period.OkDTO;
import com.aquarium.dto.period.PeriodCreationDTO;
import com.aquarium.dto.period.PeriodDTO;
import com.aquarium.dto.period.PeriodFinancialDTO;
import com.aquarium.models.tables.Period;

@Component
public class PeriodMapper {

    public PeriodDTO toDTO(Period period) {
        if (period == null) {
            return null;
        }
        return new PeriodDTO(
                period.getId(),
                period.getName(),
                period.getBegin(),
                period.getEnd());
    }

    public Period toEntity(PeriodCreationDTO dto) {
        if (dto == null) {
            return null;
        }
        Period period = new Period();
        period.setName(dto.name());
        period.setBegin(dto.begin());
        return period;
    }

    public List<PeriodDTO> toDTOList(List<Period> periods) {
        if (periods == null) {
            return null;
        }
        return periods.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public PeriodFinancialDTO toSummaryDTO(double expense, double income, double benefit, boolean closed) {
        return new PeriodFinancialDTO(expense, income, benefit, closed);
    }

    public OkDTO ok(int id) {
        return new OkDTO(true, id);
    }

    public OkDTO notOk(int id) {
        return new OkDTO(false, id);
    }
}
