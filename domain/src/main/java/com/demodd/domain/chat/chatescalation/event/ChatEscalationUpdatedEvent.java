package com.demodd.domain.chat.chatescalation.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ChatEscalationUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ChatEscalationUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "chatescalation.updated";
    }
}
