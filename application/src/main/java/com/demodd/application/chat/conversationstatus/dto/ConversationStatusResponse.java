package com.demodd.application.chat.conversationstatus.dto;

import com.demodd.domain.chat.conversationstatus.model.aggregate.ConversationStatus;

import java.time.Instant;
import java.util.UUID;

public record ConversationStatusResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ConversationStatusResponse fromDomain(ConversationStatus entity) {
        return new ConversationStatusResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
