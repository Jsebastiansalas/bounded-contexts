package com.demodd.domain.chat.escalationstatus.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record EscalationStatusUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public EscalationStatusUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "escalationstatus.updated";
    }
}
