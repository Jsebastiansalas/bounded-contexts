package com.demodd.domain.chat.chatmessage.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ChatMessageCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ChatMessageCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "chatmessage.created";
    }
}
