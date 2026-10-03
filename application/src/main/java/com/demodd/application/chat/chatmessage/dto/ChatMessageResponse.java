package com.demodd.application.chat.chatmessage.dto;

import com.demodd.domain.chat.chatmessage.model.aggregate.ChatMessage;

import java.time.Instant;
import java.util.UUID;

public record ChatMessageResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ChatMessageResponse fromDomain(ChatMessage entity) {
        return new ChatMessageResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
