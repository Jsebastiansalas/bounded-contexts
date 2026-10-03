package com.demodd.domain.chat.airunstatus.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record AiRunStatusCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public AiRunStatusCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "airunstatus.created";
    }
}
