package com.demodd.infrastructure.clinical.clinicalrecord.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClinicalRecordSpringDataJpaRepository extends JpaRepository<ClinicalRecordJpaEntity, UUID> {
}
