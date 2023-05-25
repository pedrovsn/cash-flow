package com.pedrovsn.cashflow.mapper.impl;

import com.pedrovsn.cashflow.domain.Register;
import com.pedrovsn.cashflow.domain.RegisterType;
import com.pedrovsn.cashflow.infrastructure.database.entity.RegisterEntity;
import com.pedrovsn.cashflow.mapper.RegisterEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class RegisterEntityMapperImpl implements RegisterEntityMapper {

    @Override
    public RegisterEntity fromDomain(Register register) {
        return new RegisterEntity(
                register.id(),
                register.type().name(),
                register.amount(),
                register.timestamp()
        );
    }

    @Override
    public Register fromEntity(RegisterEntity entity) {
        return new Register(
                entity.getId(),
                RegisterType.valueOf(entity.getType()),
                entity.getAmount(),
                entity.getTimestamp()
        );
    }
}
