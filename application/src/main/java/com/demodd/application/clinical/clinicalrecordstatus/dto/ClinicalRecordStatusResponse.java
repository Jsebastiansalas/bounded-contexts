package com.demodd.application.clinical.clinicalrecordstatus.dto;

import com.demodd.domain.clinical.clinicalrecordstatus.model.aggregate.ClinicalRecordStatus;

import java.time.Instant;
import java.util.UUID;

public record ClinicalRecordStatusResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ClinicalRecordStatusResponse fromDomain(ClinicalRecordStatus entity) {
        return new ClinicalRecordStatusResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
