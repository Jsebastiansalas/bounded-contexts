package com.demodd.domain.clinical.treatmentplan.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record TreatmentPlanUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public TreatmentPlanUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "treatmentplan.updated";
    }
}
