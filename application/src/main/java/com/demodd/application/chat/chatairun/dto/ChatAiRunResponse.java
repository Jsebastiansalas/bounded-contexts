package com.demodd.application.chat.chatairun.dto;

import com.demodd.domain.chat.chatairun.model.aggregate.ChatAiRun;

import java.time.Instant;
import java.util.UUID;

public record ChatAiRunResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ChatAiRunResponse fromDomain(ChatAiRun entity) {
        return new ChatAiRunResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
