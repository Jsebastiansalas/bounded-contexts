package com.demodd.domain.chat.chatairun.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ChatAiRunCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ChatAiRunCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "chatairun.created";
    }
}
