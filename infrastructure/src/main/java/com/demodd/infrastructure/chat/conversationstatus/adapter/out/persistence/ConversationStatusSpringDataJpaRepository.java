package com.demodd.infrastructure.chat.conversationstatus.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConversationStatusSpringDataJpaRepository extends JpaRepository<ConversationStatusJpaEntity, UUID> {
}
