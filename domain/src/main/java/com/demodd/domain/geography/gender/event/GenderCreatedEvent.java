package com.demodd.domain.geography.gender.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record GenderCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public GenderCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "gender.created";
    }
}
