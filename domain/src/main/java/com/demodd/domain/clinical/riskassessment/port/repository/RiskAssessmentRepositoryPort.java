package com.demodd.domain.clinical.riskassessment.port.repository;

import com.demodd.domain.clinical.riskassessment.model.aggregate.RiskAssessment;
import com.demodd.domain.clinical.riskassessment.model.valueobject.RiskAssessmentId;

import java.util.List;
import java.util.Optional;

public interface RiskAssessmentRepositoryPort {

    RiskAssessment save(RiskAssessment entity);

    Optional<RiskAssessment> findById(RiskAssessmentId id);

    List<RiskAssessment> findAll();

    void deleteById(RiskAssessmentId id);

    boolean existsById(RiskAssessmentId id);
}
