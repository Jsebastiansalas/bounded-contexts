package com.demodd.application.chat.chatairunerror.dto;

import com.demodd.domain.chat.chatairunerror.model.aggregate.ChatAiRunError;

import java.time.Instant;
import java.util.UUID;

public record ChatAiRunErrorResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ChatAiRunErrorResponse fromDomain(ChatAiRunError entity) {
        return new ChatAiRunErrorResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
