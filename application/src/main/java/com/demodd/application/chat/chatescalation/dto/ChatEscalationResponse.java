package com.demodd.application.chat.chatescalation.dto;

import com.demodd.domain.chat.chatescalation.model.aggregate.ChatEscalation;

import java.time.Instant;
import java.util.UUID;

public record ChatEscalationResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ChatEscalationResponse fromDomain(ChatEscalation entity) {
        return new ChatEscalationResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
