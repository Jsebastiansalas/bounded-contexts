package com.demodd.domain.chat.escalationstatus.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record EscalationStatusCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public EscalationStatusCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "escalationstatus.created";
    }
}
