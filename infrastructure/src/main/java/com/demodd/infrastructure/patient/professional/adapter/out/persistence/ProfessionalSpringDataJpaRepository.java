package com.demodd.infrastructure.patient.professional.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfessionalSpringDataJpaRepository extends JpaRepository<ProfessionalJpaEntity, UUID> {
}
