package com.demodd.domain.patient.emailcontact.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record EmailContactCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public EmailContactCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "emailcontact.created";
    }
}
