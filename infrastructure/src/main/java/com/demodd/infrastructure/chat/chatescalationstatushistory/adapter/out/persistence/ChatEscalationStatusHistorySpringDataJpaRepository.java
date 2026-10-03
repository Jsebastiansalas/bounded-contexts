package com.demodd.infrastructure.chat.chatescalationstatushistory.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatEscalationStatusHistorySpringDataJpaRepository extends JpaRepository<ChatEscalationStatusHistoryJpaEntity, UUID> {
}
