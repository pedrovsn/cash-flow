package com.pedrovsn.cashflow.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Register (
        Long id,
        RegisterType type,
        BigDecimal amount,
        LocalDateTime timestamp
) {
}
