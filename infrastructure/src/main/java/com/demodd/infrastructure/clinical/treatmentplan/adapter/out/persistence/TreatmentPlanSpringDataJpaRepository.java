package com.demodd.infrastructure.clinical.treatmentplan.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TreatmentPlanSpringDataJpaRepository extends JpaRepository<TreatmentPlanJpaEntity, UUID> {
}
