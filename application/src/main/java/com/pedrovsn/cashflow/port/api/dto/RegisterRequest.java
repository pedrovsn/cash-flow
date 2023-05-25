package com.pedrovsn.cashflow.port.api.dto;

import com.pedrovsn.cashflow.domain.RegisterType;

import java.math.BigDecimal;

public record RegisterRequest(
        RegisterType type,
        BigDecimal amount
) {

}
