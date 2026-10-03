package com.demodd.domain.patient.phonecontact.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record PhoneContactCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public PhoneContactCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "phonecontact.created";
    }
}
