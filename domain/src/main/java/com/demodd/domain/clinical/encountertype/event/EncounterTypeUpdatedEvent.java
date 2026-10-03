package com.demodd.domain.clinical.encountertype.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record EncounterTypeUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public EncounterTypeUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "encountertype.updated";
    }
}
