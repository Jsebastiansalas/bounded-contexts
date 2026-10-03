package com.demodd.domain.chat.conversationstatus.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ConversationStatusUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ConversationStatusUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "conversationstatus.updated";
    }
}
