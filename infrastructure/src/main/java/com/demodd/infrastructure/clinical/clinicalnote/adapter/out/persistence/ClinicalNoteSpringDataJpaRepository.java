package com.demodd.infrastructure.clinical.clinicalnote.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClinicalNoteSpringDataJpaRepository extends JpaRepository<ClinicalNoteJpaEntity, UUID> {
}
