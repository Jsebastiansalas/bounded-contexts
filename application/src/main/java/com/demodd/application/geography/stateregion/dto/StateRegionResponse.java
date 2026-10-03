package com.demodd.application.geography.stateregion.dto;

import com.demodd.domain.geography.stateregion.model.aggregate.StateRegion;

import java.time.Instant;
import java.util.UUID;

public record StateRegionResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static StateRegionResponse fromDomain(StateRegion entity) {
        return new StateRegionResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
