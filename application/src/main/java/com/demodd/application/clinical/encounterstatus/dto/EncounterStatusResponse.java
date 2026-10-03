package com.demodd.application.clinical.encounterstatus.dto;

import com.demodd.domain.clinical.encounterstatus.model.aggregate.EncounterStatus;

import java.time.Instant;
import java.util.UUID;

public record EncounterStatusResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static EncounterStatusResponse fromDomain(EncounterStatus entity) {
        return new EncounterStatusResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
