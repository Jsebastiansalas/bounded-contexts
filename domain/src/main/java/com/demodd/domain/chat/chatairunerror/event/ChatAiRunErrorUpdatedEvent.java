package com.demodd.domain.chat.chatairunerror.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ChatAiRunErrorUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ChatAiRunErrorUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "chatairunerror.updated";
    }
}
