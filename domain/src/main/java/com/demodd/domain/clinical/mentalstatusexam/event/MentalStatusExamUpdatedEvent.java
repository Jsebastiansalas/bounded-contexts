package com.demodd.domain.clinical.mentalstatusexam.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record MentalStatusExamUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public MentalStatusExamUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "mentalstatusexam.updated";
    }
}
