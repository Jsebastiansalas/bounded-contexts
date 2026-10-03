package com.demodd.application.chat.sendertype.dto;

import com.demodd.domain.chat.sendertype.model.aggregate.SenderType;

import java.time.Instant;
import java.util.UUID;

public record SenderTypeResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static SenderTypeResponse fromDomain(SenderType entity) {
        return new SenderTypeResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
