package com.demodd.domain.clinical.riskassessment.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record RiskAssessmentUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public RiskAssessmentUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "riskassessment.updated";
    }
}
