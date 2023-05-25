package com.pedrovsn.cashflow.service;

import com.pedrovsn.cashflow.domain.Register;
import com.pedrovsn.cashflow.domain.RegisterReport;
import com.pedrovsn.cashflow.domain.RegisterType;
import com.pedrovsn.cashflow.repository.RegisterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportServiceTests {

    @Mock
    private RegisterRepository reportRepository;

    @InjectMocks
    private ReportService reportService;

    @Test
    void shouldGenerateReport() {
        final var reportDate = LocalDate.of(2023, 5, 25);

        when(reportRepository.findAllRegistersByLocalDateBetween(any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenReturn(List.of(
                                new Register(
                                        1L,
                                        RegisterType.CREDIT,
                                        BigDecimal.TEN,
                                        LocalDateTime.of(2023, 5, 25, 10, 0, 0)),
                                new Register(
                                        2L,
                                        RegisterType.DEBIT,
                                        BigDecimal.valueOf(-1),
                                        LocalDateTime.of(2023, 5, 25, 11, 0, 0))
                        )
                );

        RegisterReport registerReport = reportService.generateDailyReport(reportDate);
        Assertions.assertEquals(2, registerReport.registers().size());
        Assertions.assertEquals(9D, registerReport.balance().doubleValue());

    }
}
