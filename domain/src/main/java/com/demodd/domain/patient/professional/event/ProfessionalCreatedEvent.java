package com.demodd.domain.patient.professional.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ProfessionalCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ProfessionalCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "professional.created";
    }
}
