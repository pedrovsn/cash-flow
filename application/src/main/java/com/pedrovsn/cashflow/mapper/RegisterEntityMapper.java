package com.pedrovsn.cashflow.mapper;

import com.pedrovsn.cashflow.domain.Register;
import com.pedrovsn.cashflow.infrastructure.database.entity.RegisterEntity;

public interface RegisterEntityMapper {
    RegisterEntity fromDomain(Register register);

    Register fromEntity(RegisterEntity entity);
}
