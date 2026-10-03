package com.demodd.application.clinical.clinicalnote.dto;

import com.demodd.domain.clinical.clinicalnote.model.aggregate.ClinicalNote;

import java.time.Instant;
import java.util.UUID;

public record ClinicalNoteResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ClinicalNoteResponse fromDomain(ClinicalNote entity) {
        return new ClinicalNoteResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
