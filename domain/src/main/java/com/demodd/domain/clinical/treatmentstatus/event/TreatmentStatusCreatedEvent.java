package com.demodd.domain.clinical.treatmentstatus.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record TreatmentStatusCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public TreatmentStatusCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "treatmentstatus.created";
    }
}
