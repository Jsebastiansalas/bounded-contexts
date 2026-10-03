package com.demodd.application.chat.chatescalationstatushistory.dto;

import com.demodd.domain.chat.chatescalationstatushistory.model.aggregate.ChatEscalationStatusHistory;

import java.time.Instant;
import java.util.UUID;

public record ChatEscalationStatusHistoryResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ChatEscalationStatusHistoryResponse fromDomain(ChatEscalationStatusHistory entity) {
        return new ChatEscalationStatusHistoryResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
