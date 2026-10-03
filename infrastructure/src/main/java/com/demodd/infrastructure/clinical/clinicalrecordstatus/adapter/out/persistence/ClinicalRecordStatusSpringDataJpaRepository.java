package com.demodd.infrastructure.clinical.clinicalrecordstatus.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClinicalRecordStatusSpringDataJpaRepository extends JpaRepository<ClinicalRecordStatusJpaEntity, UUID> {
}
