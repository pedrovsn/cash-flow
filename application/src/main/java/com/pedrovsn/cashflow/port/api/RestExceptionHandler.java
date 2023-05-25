package com.pedrovsn.cashflow.port.api;

import com.pedrovsn.cashflow.exception.RegisterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RegisterNotFoundException.class})
    public ResponseEntity<Object> handleRegisterNotFound(Exception ex, WebRequest request) {
        return ResponseEntity
                .of(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "Register not found"))
                .build();
    }
}
