package com.demodd.domain.clinical.treatmentgoalstatus.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record TreatmentGoalStatusUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public TreatmentGoalStatusUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "treatmentgoalstatus.updated";
    }
}
