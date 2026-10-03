package com.demodd.domain.chat.chatescalationstatushistory.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ChatEscalationStatusHistoryUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ChatEscalationStatusHistoryUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "chatescalationstatushistory.updated";
    }
}
