package com.demodd.domain.patient.patient.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record PatientUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public PatientUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "patient.updated";
    }
}
