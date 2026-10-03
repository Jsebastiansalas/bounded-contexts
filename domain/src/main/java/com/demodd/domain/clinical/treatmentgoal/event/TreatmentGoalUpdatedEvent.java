package com.demodd.domain.clinical.treatmentgoal.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record TreatmentGoalUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public TreatmentGoalUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "treatmentgoal.updated";
    }
}
