package com.demodd.domain.chat.chatescalationassignment.port.repository;

import com.demodd.domain.chat.chatescalationassignment.model.aggregate.ChatEscalationAssignment;
import com.demodd.domain.chat.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;

import java.util.List;
import java.util.Optional;

public interface ChatEscalationAssignmentRepositoryPort {

    ChatEscalationAssignment save(ChatEscalationAssignment entity);

    Optional<ChatEscalationAssignment> findById(ChatEscalationAssignmentId id);

    List<ChatEscalationAssignment> findAll();

    void deleteById(ChatEscalationAssignmentId id);

    boolean existsById(ChatEscalationAssignmentId id);
}
