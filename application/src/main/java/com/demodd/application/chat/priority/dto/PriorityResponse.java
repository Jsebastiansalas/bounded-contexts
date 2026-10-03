package com.demodd.application.chat.priority.dto;

import com.demodd.domain.chat.priority.model.aggregate.Priority;

import java.time.Instant;
import java.util.UUID;

public record PriorityResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static PriorityResponse fromDomain(Priority entity) {
        return new PriorityResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
