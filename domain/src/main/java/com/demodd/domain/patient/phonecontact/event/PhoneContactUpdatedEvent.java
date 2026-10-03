package com.demodd.domain.patient.phonecontact.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record PhoneContactUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public PhoneContactUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "phonecontact.updated";
    }
}
