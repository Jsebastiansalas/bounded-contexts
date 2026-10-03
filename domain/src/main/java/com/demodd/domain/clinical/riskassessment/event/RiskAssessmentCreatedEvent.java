package com.demodd.domain.clinical.riskassessment.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record RiskAssessmentCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public RiskAssessmentCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "riskassessment.created";
    }
}
