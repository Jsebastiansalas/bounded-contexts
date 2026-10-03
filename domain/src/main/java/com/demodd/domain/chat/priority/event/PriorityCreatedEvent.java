package com.demodd.domain.chat.priority.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record PriorityCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public PriorityCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "priority.created";
    }
}
