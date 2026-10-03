package com.demodd.application.clinical.assessmenttype.dto;

import com.demodd.domain.clinical.assessmenttype.model.aggregate.AssessmentType;

import java.time.Instant;
import java.util.UUID;

public record AssessmentTypeResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static AssessmentTypeResponse fromDomain(AssessmentType entity) {
        return new AssessmentTypeResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
