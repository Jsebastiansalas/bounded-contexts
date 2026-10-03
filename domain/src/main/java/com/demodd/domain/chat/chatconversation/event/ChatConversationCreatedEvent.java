package com.demodd.domain.chat.chatconversation.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ChatConversationCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ChatConversationCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "chatconversation.created";
    }
}
