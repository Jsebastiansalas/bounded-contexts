package com.demodd.domain.chat.sendertype.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record SenderTypeCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public SenderTypeCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "sendertype.created";
    }
}
