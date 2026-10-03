package com.demodd.application.chat.escalationstatus.dto;

import com.demodd.domain.chat.escalationstatus.model.aggregate.EscalationStatus;

import java.time.Instant;
import java.util.UUID;

public record EscalationStatusResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static EscalationStatusResponse fromDomain(EscalationStatus entity) {
        return new EscalationStatusResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
