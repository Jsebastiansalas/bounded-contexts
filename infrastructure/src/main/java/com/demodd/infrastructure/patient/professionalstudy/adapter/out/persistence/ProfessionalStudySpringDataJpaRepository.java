package com.demodd.infrastructure.patient.professionalstudy.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfessionalStudySpringDataJpaRepository extends JpaRepository<ProfessionalStudyJpaEntity, UUID> {
}
