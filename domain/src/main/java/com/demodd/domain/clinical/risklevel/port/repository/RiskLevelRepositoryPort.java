package com.demodd.domain.clinical.risklevel.port.repository;

import com.demodd.domain.clinical.risklevel.model.aggregate.RiskLevel;
import com.demodd.domain.clinical.risklevel.model.valueobject.RiskLevelId;

import java.util.List;
import java.util.Optional;

public interface RiskLevelRepositoryPort {

    RiskLevel save(RiskLevel entity);

    Optional<RiskLevel> findById(RiskLevelId id);

    List<RiskLevel> findAll();

    void deleteById(RiskLevelId id);

    boolean existsById(RiskLevelId id);
}
