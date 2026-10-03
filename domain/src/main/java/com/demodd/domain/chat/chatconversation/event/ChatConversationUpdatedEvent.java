package com.demodd.domain.chat.chatconversation.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ChatConversationUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ChatConversationUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "chatconversation.updated";
    }
}
