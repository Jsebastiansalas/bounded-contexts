package com.demodd.domain.clinical.encountermodality.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record EncounterModalityCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public EncounterModalityCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "encountermodality.created";
    }
}
