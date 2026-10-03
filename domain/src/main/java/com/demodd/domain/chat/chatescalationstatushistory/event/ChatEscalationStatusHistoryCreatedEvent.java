package com.demodd.domain.chat.chatescalationstatushistory.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ChatEscalationStatusHistoryCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ChatEscalationStatusHistoryCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "chatescalationstatushistory.created";
    }
}
