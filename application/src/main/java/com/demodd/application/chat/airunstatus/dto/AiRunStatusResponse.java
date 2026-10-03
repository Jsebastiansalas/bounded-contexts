package com.demodd.application.chat.airunstatus.dto;

import com.demodd.domain.chat.airunstatus.model.aggregate.AiRunStatus;

import java.time.Instant;
import java.util.UUID;

public record AiRunStatusResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static AiRunStatusResponse fromDomain(AiRunStatus entity) {
        return new AiRunStatusResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
