package com.demodd.application.geography.professionaltype.dto;

import com.demodd.domain.geography.professionaltype.model.aggregate.ProfessionalType;

import java.time.Instant;
import java.util.UUID;

public record ProfessionalTypeResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ProfessionalTypeResponse fromDomain(ProfessionalType entity) {
        return new ProfessionalTypeResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
