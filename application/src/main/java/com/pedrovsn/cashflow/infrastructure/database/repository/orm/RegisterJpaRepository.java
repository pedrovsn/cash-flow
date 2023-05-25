package com.pedrovsn.cashflow.infrastructure.database.repository.orm;

import com.pedrovsn.cashflow.infrastructure.database.entity.RegisterEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RegisterJpaRepository extends CrudRepository<RegisterEntity, Long> {

    List<RegisterEntity> findAll();

    List<RegisterEntity> findAllByTimestampBetween(LocalDateTime startDate, LocalDateTime endDate);
}
