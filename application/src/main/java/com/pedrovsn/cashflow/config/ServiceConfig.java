package com.pedrovsn.cashflow.config;

import com.pedrovsn.cashflow.repository.RegisterRepository;
import com.pedrovsn.cashflow.service.RegisterService;
import com.pedrovsn.cashflow.service.ReportService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public RegisterService registerService(RegisterRepository registerRepository) {
        return new RegisterService(registerRepository);
    }

    @Bean
    public ReportService reportService(RegisterRepository registerRepository) {
        return new ReportService(registerRepository);
    }
}
