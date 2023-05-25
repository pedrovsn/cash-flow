package com.pedrovsn.cashflow.domain;

import java.math.BigDecimal;
import java.util.List;

public record RegisterReport(
        List<Register> registers,
        BigDecimal balance
) {
}
