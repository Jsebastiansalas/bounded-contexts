package com.demodd.application.chat.providermodelai.dto;

import com.demodd.domain.chat.providermodelai.model.aggregate.ProviderModelAi;

import java.time.Instant;
import java.util.UUID;

public record ProviderModelAiResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ProviderModelAiResponse fromDomain(ProviderModelAi entity) {
        return new ProviderModelAiResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
