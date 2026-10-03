package com.demodd.domain.clinical.medicationroute.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record MedicationRouteCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public MedicationRouteCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "medicationroute.created";
    }
}
