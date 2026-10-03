package com.demodd.infrastructure.clinical.encounter.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EncounterSpringDataJpaRepository extends JpaRepository<EncounterJpaEntity, UUID> {
}
