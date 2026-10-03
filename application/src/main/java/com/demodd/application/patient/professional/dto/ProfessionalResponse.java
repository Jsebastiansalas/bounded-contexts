package com.demodd.application.patient.professional.dto;

import com.demodd.domain.patient.professional.model.aggregate.Professional;

import java.time.Instant;
import java.util.UUID;

public record ProfessionalResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ProfessionalResponse fromDomain(Professional entity) {
        return new ProfessionalResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
