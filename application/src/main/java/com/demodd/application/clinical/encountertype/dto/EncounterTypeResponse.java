package com.demodd.application.clinical.encountertype.dto;

import com.demodd.domain.clinical.encountertype.model.aggregate.EncounterType;

import java.time.Instant;
import java.util.UUID;

public record EncounterTypeResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static EncounterTypeResponse fromDomain(EncounterType entity) {
        return new EncounterTypeResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
