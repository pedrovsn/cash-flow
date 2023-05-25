package com.pedrovsn.cashflow.service;

import com.pedrovsn.cashflow.domain.Register;
import com.pedrovsn.cashflow.domain.RegisterType;
import com.pedrovsn.cashflow.exception.RegisterNotFoundException;
import com.pedrovsn.cashflow.repository.RegisterRepository;

import java.util.List;

public class RegisterService {

    private final RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public Register createRegister(Register register) {
        return registerRepository.save(register);
    }

    public Register updateRegister(Long id, Register register) {
        if(registerRepository.existsById(id)) {
            return registerRepository.save(register);
        } else {
            throw new RegisterNotFoundException();
        }
    }

    public Register findById(Long id) {
        if(registerRepository.existsById(id)) {
            return registerRepository.findById(id);
        } else {
            throw new RegisterNotFoundException();
        }
    }

    public List<Register> findAllRegisters() {
        return registerRepository.findAll();
    }

    public void deleteRegisterById(Long id) {
        if(registerRepository.existsById(id)) {
            registerRepository.deleteRegisterById(id);
        } else {
            throw new RegisterNotFoundException();
        }
    }

}
