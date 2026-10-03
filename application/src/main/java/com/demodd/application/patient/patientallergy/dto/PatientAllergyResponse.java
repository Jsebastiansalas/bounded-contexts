package com.demodd.application.patient.patientallergy.dto;

import com.demodd.domain.patient.patientallergy.model.aggregate.PatientAllergy;

import java.time.Instant;
import java.util.UUID;

public record PatientAllergyResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static PatientAllergyResponse fromDomain(PatientAllergy entity) {
        return new PatientAllergyResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
