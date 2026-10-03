package com.demodd.application.chat.chatparticipant.dto;

import com.demodd.domain.chat.chatparticipant.model.aggregate.ChatParticipant;

import java.time.Instant;
import java.util.UUID;

public record ChatParticipantResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ChatParticipantResponse fromDomain(ChatParticipant entity) {
        return new ChatParticipantResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
