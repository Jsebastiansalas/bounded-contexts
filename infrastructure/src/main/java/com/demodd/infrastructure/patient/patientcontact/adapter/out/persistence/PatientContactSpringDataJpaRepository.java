package com.demodd.infrastructure.patient.patientcontact.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientContactSpringDataJpaRepository extends JpaRepository<PatientContactJpaEntity, UUID> {
}
