package com.demodd.application.clinical.diagnosticsystem.dto;

import com.demodd.domain.clinical.diagnosticsystem.model.aggregate.DiagnosticSystem;

import java.time.Instant;
import java.util.UUID;

public record DiagnosticSystemResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static DiagnosticSystemResponse fromDomain(DiagnosticSystem entity) {
        return new DiagnosticSystemResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
