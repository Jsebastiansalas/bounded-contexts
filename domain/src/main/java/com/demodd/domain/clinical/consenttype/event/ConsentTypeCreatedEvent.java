package com.demodd.domain.clinical.consenttype.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ConsentTypeCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ConsentTypeCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "consenttype.created";
    }
}
