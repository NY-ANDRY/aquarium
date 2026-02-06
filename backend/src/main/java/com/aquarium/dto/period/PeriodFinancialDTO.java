package com.aquarium.dto.period;

import java.math.BigDecimal;

public record PeriodFinancialDTO(BigDecimal expense, BigDecimal income, BigDecimal benefit, boolean closed) {

    public static PeriodFinancialDTO fromLogic(BigDecimal expense, BigDecimal income, BigDecimal benefit, boolean closed) {
        return new PeriodFinancialDTO(expense, income, benefit, closed);
    }
}
