package com.demodd.infrastructure.clinical.encountermodality.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EncounterModalitySpringDataJpaRepository extends JpaRepository<EncounterModalityJpaEntity, UUID> {
}
