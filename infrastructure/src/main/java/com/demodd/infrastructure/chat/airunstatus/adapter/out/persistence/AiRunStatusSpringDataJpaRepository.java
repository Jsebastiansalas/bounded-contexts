package com.demodd.infrastructure.chat.airunstatus.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AiRunStatusSpringDataJpaRepository extends JpaRepository<AiRunStatusJpaEntity, UUID> {
}
