package com.demodd.infrastructure.patient.patient.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientSpringDataJpaRepository extends JpaRepository<PatientJpaEntity, UUID> {
}
