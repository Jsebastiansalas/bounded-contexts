package com.demodd.infrastructure.chat.chatescalation.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatEscalationSpringDataJpaRepository extends JpaRepository<ChatEscalationJpaEntity, UUID> {
}
