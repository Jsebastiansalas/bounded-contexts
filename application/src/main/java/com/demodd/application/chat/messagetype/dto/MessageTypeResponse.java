package com.demodd.application.chat.messagetype.dto;

import com.demodd.domain.chat.messagetype.model.aggregate.MessageType;

import java.time.Instant;
import java.util.UUID;

public record MessageTypeResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static MessageTypeResponse fromDomain(MessageType entity) {
        return new MessageTypeResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
