package com.demodd.application.patient.professionalstudy.dto;

import com.demodd.domain.patient.professionalstudy.model.aggregate.ProfessionalStudy;

import java.time.Instant;
import java.util.UUID;

public record ProfessionalStudyResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ProfessionalStudyResponse fromDomain(ProfessionalStudy entity) {
        return new ProfessionalStudyResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
