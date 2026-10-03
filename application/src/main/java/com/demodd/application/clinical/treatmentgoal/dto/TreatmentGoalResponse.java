package com.demodd.application.clinical.treatmentgoal.dto;

import com.demodd.domain.clinical.treatmentgoal.model.aggregate.TreatmentGoal;

import java.time.Instant;
import java.util.UUID;

public record TreatmentGoalResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static TreatmentGoalResponse fromDomain(TreatmentGoal entity) {
        return new TreatmentGoalResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
