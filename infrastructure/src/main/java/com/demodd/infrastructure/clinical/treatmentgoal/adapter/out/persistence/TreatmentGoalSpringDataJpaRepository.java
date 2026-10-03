package com.demodd.infrastructure.clinical.treatmentgoal.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TreatmentGoalSpringDataJpaRepository extends JpaRepository<TreatmentGoalJpaEntity, UUID> {
}
