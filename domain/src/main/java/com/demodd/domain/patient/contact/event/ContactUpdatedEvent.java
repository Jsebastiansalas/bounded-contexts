package com.demodd.domain.patient.contact.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ContactUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ContactUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "contact.updated";
    }
}
