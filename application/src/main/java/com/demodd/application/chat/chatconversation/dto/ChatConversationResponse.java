package com.demodd.application.chat.chatconversation.dto;

import com.demodd.domain.chat.chatconversation.model.aggregate.ChatConversation;

import java.time.Instant;
import java.util.UUID;

public record ChatConversationResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ChatConversationResponse fromDomain(ChatConversation entity) {
        return new ChatConversationResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
