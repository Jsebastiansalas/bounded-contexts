package com.demodd.domain.clinical.mentalstatusexam.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record MentalStatusExamCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public MentalStatusExamCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "mentalstatusexam.created";
    }
}
