package com.demodd.infrastructure.chat.chatescalationassignment.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatEscalationAssignmentSpringDataJpaRepository extends JpaRepository<ChatEscalationAssignmentJpaEntity, UUID> {
}
