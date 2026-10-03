package com.demodd.application.chat.chatairunmetric.dto;

import com.demodd.domain.chat.chatairunmetric.model.aggregate.ChatAiRunMetric;

import java.time.Instant;
import java.util.UUID;

public record ChatAiRunMetricResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ChatAiRunMetricResponse fromDomain(ChatAiRunMetric entity) {
        return new ChatAiRunMetricResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
