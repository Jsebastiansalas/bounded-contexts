package com.demodd.application.clinical.encountermodality.dto;

import com.demodd.domain.clinical.encountermodality.model.aggregate.EncounterModality;

import java.time.Instant;
import java.util.UUID;

public record EncounterModalityResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static EncounterModalityResponse fromDomain(EncounterModality entity) {
        return new EncounterModalityResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
