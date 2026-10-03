package com.demodd.domain.chat.priority.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record PriorityUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public PriorityUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "priority.updated";
    }
}
