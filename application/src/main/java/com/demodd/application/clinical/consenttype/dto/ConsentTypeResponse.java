package com.demodd.application.clinical.consenttype.dto;

import com.demodd.domain.clinical.consenttype.model.aggregate.ConsentType;

import java.time.Instant;
import java.util.UUID;

public record ConsentTypeResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ConsentTypeResponse fromDomain(ConsentType entity) {
        return new ConsentTypeResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
