package com.pedrovsn.cashflow.repository;

import com.pedrovsn.cashflow.domain.Register;

import java.time.LocalDateTime;
import java.util.List;

public interface RegisterRepository {

    Register save(Register register);

    boolean existsById(Long id);

    Register findById(Long id);

    List<Register> findAll();

    List<Register> findAllRegistersByLocalDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    void deleteRegisterById(Long id);
}
