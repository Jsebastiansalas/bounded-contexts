package com.demodd.application.clinical.medicationroute.dto;

import com.demodd.domain.clinical.medicationroute.model.aggregate.MedicationRoute;

import java.time.Instant;
import java.util.UUID;

public record MedicationRouteResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static MedicationRouteResponse fromDomain(MedicationRoute entity) {
        return new MedicationRouteResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
