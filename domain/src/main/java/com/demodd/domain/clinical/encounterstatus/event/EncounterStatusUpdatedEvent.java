package com.demodd.domain.clinical.encounterstatus.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record EncounterStatusUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public EncounterStatusUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "encounterstatus.updated";
    }
}
