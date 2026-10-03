package com.demodd.domain.clinical.assessmenttype.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record AssessmentTypeUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public AssessmentTypeUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "assessmenttype.updated";
    }
}
