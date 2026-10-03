package com.demodd.application.geography.relationshiptype.dto;

import com.demodd.domain.geography.relationshiptype.model.aggregate.RelationshipType;

import java.time.Instant;
import java.util.UUID;

public record RelationshipTypeResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static RelationshipTypeResponse fromDomain(RelationshipType entity) {
        return new RelationshipTypeResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
