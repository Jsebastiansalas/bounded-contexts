package com.demodd.application.clinical.riskassessment.dto;

import com.demodd.domain.clinical.riskassessment.model.aggregate.RiskAssessment;

import java.time.Instant;
import java.util.UUID;

public record RiskAssessmentResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static RiskAssessmentResponse fromDomain(RiskAssessment entity) {
        return new RiskAssessmentResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
