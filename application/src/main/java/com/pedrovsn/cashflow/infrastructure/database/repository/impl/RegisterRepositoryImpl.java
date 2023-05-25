package com.pedrovsn.cashflow.infrastructure.database.repository.impl;

import com.pedrovsn.cashflow.domain.Register;
import com.pedrovsn.cashflow.infrastructure.database.entity.RegisterEntity;
import com.pedrovsn.cashflow.infrastructure.database.repository.orm.RegisterJpaRepository;
import com.pedrovsn.cashflow.mapper.RegisterEntityMapper;
import com.pedrovsn.cashflow.repository.RegisterRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class RegisterRepositoryImpl implements RegisterRepository {

    private final RegisterJpaRepository registerJpaRepository;

    private final RegisterEntityMapper registerEntityMapper;

    public RegisterRepositoryImpl(
            RegisterJpaRepository registerJpaRepository,
            RegisterEntityMapper registerEntityMapper) {
        this.registerJpaRepository = registerJpaRepository;
        this.registerEntityMapper = registerEntityMapper;
    }

    @Override
    public Register save(Register register) {
        RegisterEntity registerEntity = registerEntityMapper.fromDomain(register);
        registerJpaRepository.save(registerEntity);
        return registerEntityMapper.fromEntity(registerEntity);
    }

    @Override
    public boolean existsById(Long id) {
        return registerJpaRepository.existsById(id);
    }

    @Override
    public Register findById(Long id) {
        return registerJpaRepository.findById(id)
                .map(registerEntityMapper::fromEntity)
                .orElse(null);
    }

    @Override
    public List<Register> findAll() {
        return registerJpaRepository.findAll()
                .stream()
                .map(registerEntityMapper::fromEntity)
                .toList();
    }

    @Override
    public List<Register> findAllRegistersByLocalDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return registerJpaRepository.findAllByTimestampBetween(startDate, endDate)
                .stream()
                .map(registerEntityMapper::fromEntity)
                .toList();
    }

    @Override
    public void deleteRegisterById(Long id) {
        registerJpaRepository.deleteById(id);
    }
}
