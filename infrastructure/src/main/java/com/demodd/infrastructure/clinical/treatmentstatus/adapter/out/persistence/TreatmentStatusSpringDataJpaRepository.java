package com.demodd.infrastructure.clinical.treatmentstatus.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TreatmentStatusSpringDataJpaRepository extends JpaRepository<TreatmentStatusJpaEntity, UUID> {
}
