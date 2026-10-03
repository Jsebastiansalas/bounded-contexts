package com.demodd.domain.geography.citymunicipality.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record CityMunicipalityUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public CityMunicipalityUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "citymunicipality.updated";
    }
}
