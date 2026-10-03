package com.demodd.infrastructure.clinical.riskassessment.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RiskAssessmentSpringDataJpaRepository extends JpaRepository<RiskAssessmentJpaEntity, UUID> {
}
