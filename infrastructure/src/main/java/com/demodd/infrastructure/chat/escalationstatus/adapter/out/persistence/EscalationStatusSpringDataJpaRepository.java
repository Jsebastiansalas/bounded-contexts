package com.demodd.infrastructure.chat.escalationstatus.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EscalationStatusSpringDataJpaRepository extends JpaRepository<EscalationStatusJpaEntity, UUID> {
}
