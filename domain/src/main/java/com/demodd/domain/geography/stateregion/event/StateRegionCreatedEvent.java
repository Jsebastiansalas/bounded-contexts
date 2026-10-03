package com.demodd.domain.geography.stateregion.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record StateRegionCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public StateRegionCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "stateregion.created";
    }
}
