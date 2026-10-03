package com.demodd.domain.clinical.encounter.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record EncounterUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public EncounterUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "encounter.updated";
    }
}
