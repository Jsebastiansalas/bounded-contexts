package com.demodd.domain.chat.conversationstatus.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ConversationStatusCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ConversationStatusCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "conversationstatus.created";
    }
}
