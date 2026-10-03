package com.demodd.application.chat.chatescalationassignment.dto;

import com.demodd.domain.chat.chatescalationassignment.model.aggregate.ChatEscalationAssignment;

import java.time.Instant;
import java.util.UUID;

public record ChatEscalationAssignmentResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ChatEscalationAssignmentResponse fromDomain(ChatEscalationAssignment entity) {
        return new ChatEscalationAssignmentResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
