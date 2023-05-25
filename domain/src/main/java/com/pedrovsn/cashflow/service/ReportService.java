package com.pedrovsn.cashflow.service;

import com.pedrovsn.cashflow.domain.Register;
import com.pedrovsn.cashflow.domain.RegisterReport;
import com.pedrovsn.cashflow.repository.RegisterRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ReportService {

    private final RegisterRepository registerRepository;

    public ReportService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public RegisterReport generateDailyReport(LocalDate date) {
        final LocalDateTime startDate = LocalDateTime.of(date, LocalTime.of(0, 0, 0));
        final LocalDateTime endDate = LocalDateTime.of(date, LocalTime.of(23, 59, 59));

        List<Register> allRegistersByLocalDateBetween = registerRepository.findAllRegistersByLocalDateBetween(startDate, endDate);

        return new RegisterReport(
                allRegistersByLocalDateBetween,
                allRegistersByLocalDateBetween
                        .stream()
                        .map(Register::amount)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        );
    }
}
