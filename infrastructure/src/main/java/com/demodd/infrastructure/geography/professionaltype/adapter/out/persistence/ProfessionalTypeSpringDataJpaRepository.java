package com.demodd.infrastructure.geography.professionaltype.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfessionalTypeSpringDataJpaRepository extends JpaRepository<ProfessionalTypeJpaEntity, UUID> {
}
