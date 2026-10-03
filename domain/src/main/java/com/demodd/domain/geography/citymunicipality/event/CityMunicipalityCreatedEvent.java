package com.demodd.domain.geography.citymunicipality.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record CityMunicipalityCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public CityMunicipalityCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "citymunicipality.created";
    }
}
