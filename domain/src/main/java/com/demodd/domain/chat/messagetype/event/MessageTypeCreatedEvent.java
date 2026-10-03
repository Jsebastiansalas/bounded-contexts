package com.demodd.domain.chat.messagetype.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record MessageTypeCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public MessageTypeCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "messagetype.created";
    }
}
