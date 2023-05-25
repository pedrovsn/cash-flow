package com.pedrovsn.cashflow.mapper;

import com.pedrovsn.cashflow.domain.Register;
import com.pedrovsn.cashflow.port.api.dto.RegisterRequest;

public interface RegisterRequestMapper {

    Register fromRequest(RegisterRequest registerRequest);
}
