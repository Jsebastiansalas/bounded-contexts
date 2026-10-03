package com.demodd.application.clinical.treatmentplan.dto;

import com.demodd.domain.clinical.treatmentplan.model.aggregate.TreatmentPlan;

import java.time.Instant;
import java.util.UUID;

public record TreatmentPlanResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static TreatmentPlanResponse fromDomain(TreatmentPlan entity) {
        return new TreatmentPlanResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
