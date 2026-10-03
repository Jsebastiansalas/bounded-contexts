package com.demodd.domain.chat.messagetype.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record MessageTypeUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public MessageTypeUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "messagetype.updated";
    }
}
