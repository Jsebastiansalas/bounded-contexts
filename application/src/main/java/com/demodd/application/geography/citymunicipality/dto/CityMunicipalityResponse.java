package com.demodd.application.geography.citymunicipality.dto;

import com.demodd.domain.geography.citymunicipality.model.aggregate.CityMunicipality;

import java.time.Instant;
import java.util.UUID;

public record CityMunicipalityResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static CityMunicipalityResponse fromDomain(CityMunicipality entity) {
        return new CityMunicipalityResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
