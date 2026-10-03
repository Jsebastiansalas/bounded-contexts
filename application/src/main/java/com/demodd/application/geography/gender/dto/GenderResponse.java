package com.demodd.application.geography.gender.dto;

import com.demodd.domain.geography.gender.model.aggregate.Gender;

import java.time.Instant;
import java.util.UUID;

public record GenderResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static GenderResponse fromDomain(Gender entity) {
        return new GenderResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
