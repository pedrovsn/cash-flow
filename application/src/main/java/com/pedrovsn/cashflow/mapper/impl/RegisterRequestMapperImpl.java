package com.pedrovsn.cashflow.mapper.impl;

import com.pedrovsn.cashflow.domain.Register;
import com.pedrovsn.cashflow.domain.RegisterType;
import com.pedrovsn.cashflow.mapper.RegisterRequestMapper;
import com.pedrovsn.cashflow.port.api.dto.RegisterRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class RegisterRequestMapperImpl implements RegisterRequestMapper {
    @Override
    public Register fromRequest(RegisterRequest registerRequest) {
        BigDecimal amount = Optional.ofNullable(registerRequest.amount())
                .map(a -> {
                    if (registerRequest.type() == RegisterType.DEBIT && a.doubleValue() > 0) {
                        return a.multiply(BigDecimal.valueOf(-1));
                    } else {
                        return a;
                    }
                }).orElse(BigDecimal.ZERO);

        return new Register(
                null,
                registerRequest.type(),
                amount,
                LocalDateTime.now()
        );
    }
}
