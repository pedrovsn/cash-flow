package com.pedrovsn.cashflow.port;

import com.pedrovsn.cashflow.domain.Register;
import com.pedrovsn.cashflow.mapper.RegisterRequestMapper;
import com.pedrovsn.cashflow.port.api.dto.RegisterRequest;
import com.pedrovsn.cashflow.service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;

    private final RegisterRequestMapper registerRequestMapper;

    public RegisterController(
            RegisterService registerService,
            RegisterRequestMapper registerRequestMapper) {
        this.registerService = registerService;
        this.registerRequestMapper = registerRequestMapper;
    }

    @PostMapping
    public ResponseEntity<Register> createRegister(@RequestBody RegisterRequest register) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registerService.createRegister(registerRequestMapper.fromRequest(register)));
    }

    @PutMapping("/id")
    public ResponseEntity<Register> updateRegister(@PathVariable("id") Long id, @RequestBody RegisterRequest register) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(registerService.updateRegister(id, registerRequestMapper.fromRequest(register)));
    }

    @GetMapping("/id")
    public ResponseEntity<Register> getRegisterById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(registerService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Register>> getAllRegisters() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(registerService.findAllRegisters());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegister(@PathVariable("id") Long id) {
        return ResponseEntity
                .noContent()
                .build();
    }
}
