package com.demodd.domain.chat.aimodel.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record AiModelUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public AiModelUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "aimodel.updated";
    }
}
