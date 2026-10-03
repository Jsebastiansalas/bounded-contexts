package com.demodd.domain.clinical.consenttype.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ConsentTypeUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ConsentTypeUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "consenttype.updated";
    }
}
