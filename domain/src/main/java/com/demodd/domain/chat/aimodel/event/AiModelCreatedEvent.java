package com.demodd.domain.chat.aimodel.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record AiModelCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public AiModelCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "aimodel.created";
    }
}
