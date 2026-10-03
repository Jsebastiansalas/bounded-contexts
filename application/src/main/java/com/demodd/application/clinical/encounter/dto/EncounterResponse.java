package com.demodd.application.clinical.encounter.dto;

import com.demodd.domain.clinical.encounter.model.aggregate.Encounter;

import java.time.Instant;
import java.util.UUID;

public record EncounterResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static EncounterResponse fromDomain(Encounter entity) {
        return new EncounterResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
