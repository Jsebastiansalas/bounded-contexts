package com.demodd.domain.geography.study.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record StudyUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public StudyUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "study.updated";
    }
}
