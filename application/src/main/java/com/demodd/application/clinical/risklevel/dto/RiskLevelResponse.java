package com.demodd.application.clinical.risklevel.dto;

import com.demodd.domain.clinical.risklevel.model.aggregate.RiskLevel;

import java.time.Instant;
import java.util.UUID;

public record RiskLevelResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static RiskLevelResponse fromDomain(RiskLevel entity) {
        return new RiskLevelResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
