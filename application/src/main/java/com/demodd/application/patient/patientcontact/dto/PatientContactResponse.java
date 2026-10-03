package com.demodd.application.patient.patientcontact.dto;

import com.demodd.domain.patient.patientcontact.model.aggregate.PatientContact;

import java.time.Instant;
import java.util.UUID;

public record PatientContactResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static PatientContactResponse fromDomain(PatientContact entity) {
        return new PatientContactResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
