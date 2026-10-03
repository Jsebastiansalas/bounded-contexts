package com.demodd.infrastructure.chat.chatconversation.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatConversationSpringDataJpaRepository extends JpaRepository<ChatConversationJpaEntity, UUID> {
}
