package com.demodd.application.geography.documenttype.dto;

import com.demodd.domain.geography.documenttype.model.aggregate.DocumentType;

import java.time.Instant;
import java.util.UUID;

public record DocumentTypeResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static DocumentTypeResponse fromDomain(DocumentType entity) {
        return new DocumentTypeResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
