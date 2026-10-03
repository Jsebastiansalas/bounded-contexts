package com.demodd.domain.clinical.treatmentgoal.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record TreatmentGoalCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public TreatmentGoalCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "treatmentgoal.created";
    }
}
