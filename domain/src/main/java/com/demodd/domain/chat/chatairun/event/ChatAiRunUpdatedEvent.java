package com.demodd.domain.chat.chatairun.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ChatAiRunUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ChatAiRunUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "chatairun.updated";
    }
}
