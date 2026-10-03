package com.demodd.infrastructure.clinical.encounterstatus.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EncounterStatusSpringDataJpaRepository extends JpaRepository<EncounterStatusJpaEntity, UUID> {
}
