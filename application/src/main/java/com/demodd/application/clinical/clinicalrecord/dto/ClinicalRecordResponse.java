package com.demodd.application.clinical.clinicalrecord.dto;

import com.demodd.domain.clinical.clinicalrecord.model.aggregate.ClinicalRecord;

import java.time.Instant;
import java.util.UUID;

public record ClinicalRecordResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ClinicalRecordResponse fromDomain(ClinicalRecord entity) {
        return new ClinicalRecordResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
