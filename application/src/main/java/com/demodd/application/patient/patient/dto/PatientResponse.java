package com.demodd.application.patient.patient.dto;

import com.demodd.domain.patient.patient.model.aggregate.Patient;

import java.time.Instant;
import java.util.UUID;

public record PatientResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static PatientResponse fromDomain(Patient entity) {
        return new PatientResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
