package com.demodd.domain.chat.chatmessage.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ChatMessageUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ChatMessageUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "chatmessage.updated";
    }
}
