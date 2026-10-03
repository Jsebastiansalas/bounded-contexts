package com.demodd.application.geography.study.dto;

import com.demodd.domain.geography.study.model.aggregate.Study;

import java.time.Instant;
import java.util.UUID;

public record StudyResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static StudyResponse fromDomain(Study entity) {
        return new StudyResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
