package com.pedrovsn.cashflow.port;

import com.pedrovsn.cashflow.domain.RegisterReport;
import com.pedrovsn.cashflow.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public ResponseEntity<RegisterReport> createRegister(@RequestParam LocalDate date) {
        return ResponseEntity.status(HttpStatus.OK).body(reportService.generateDailyReport(date));
    }
}
