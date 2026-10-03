package com.demodd.domain.clinical.treatmentplan.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record TreatmentPlanCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public TreatmentPlanCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "treatmentplan.created";
    }
}
