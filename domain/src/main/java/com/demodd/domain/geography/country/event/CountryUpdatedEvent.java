package com.demodd.domain.geography.country.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record CountryUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public CountryUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "country.updated";
    }
}
