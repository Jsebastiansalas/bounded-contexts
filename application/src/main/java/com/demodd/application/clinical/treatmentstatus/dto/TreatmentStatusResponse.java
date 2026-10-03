package com.demodd.application.clinical.treatmentstatus.dto;

import com.demodd.domain.clinical.treatmentstatus.model.aggregate.TreatmentStatus;

import java.time.Instant;
import java.util.UUID;

public record TreatmentStatusResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static TreatmentStatusResponse fromDomain(TreatmentStatus entity) {
        return new TreatmentStatusResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
