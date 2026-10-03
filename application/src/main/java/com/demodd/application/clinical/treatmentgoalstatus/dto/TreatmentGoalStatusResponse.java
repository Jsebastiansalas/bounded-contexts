package com.demodd.application.clinical.treatmentgoalstatus.dto;

import com.demodd.domain.clinical.treatmentgoalstatus.model.aggregate.TreatmentGoalStatus;

import java.time.Instant;
import java.util.UUID;

public record TreatmentGoalStatusResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static TreatmentGoalStatusResponse fromDomain(TreatmentGoalStatus entity) {
        return new TreatmentGoalStatusResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
