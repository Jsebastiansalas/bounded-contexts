package com.demodd.infrastructure.clinical.treatmentgoalstatus.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TreatmentGoalStatusSpringDataJpaRepository extends JpaRepository<TreatmentGoalStatusJpaEntity, UUID> {
}
