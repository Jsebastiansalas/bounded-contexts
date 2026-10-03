package com.demodd.application.geography.country.dto;

import com.demodd.domain.geography.country.model.aggregate.Country;

import java.time.Instant;
import java.util.UUID;

public record CountryResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static CountryResponse fromDomain(Country entity) {
        return new CountryResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
