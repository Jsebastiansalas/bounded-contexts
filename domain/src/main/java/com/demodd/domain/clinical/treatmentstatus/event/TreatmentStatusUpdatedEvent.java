package com.demodd.domain.clinical.treatmentstatus.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record TreatmentStatusUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public TreatmentStatusUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "treatmentstatus.updated";
    }
}
