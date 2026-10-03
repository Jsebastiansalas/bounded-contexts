package com.demodd.application.chat.aimodel.dto;

import com.demodd.domain.chat.aimodel.model.aggregate.AiModel;

import java.time.Instant;
import java.util.UUID;

public record AiModelResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static AiModelResponse fromDomain(AiModel entity) {
        return new AiModelResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
