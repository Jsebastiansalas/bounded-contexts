package com.demodd.domain.geography.study.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record StudyCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public StudyCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "study.created";
    }
}
