package com.demodd.domain.chat.sendertype.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record SenderTypeUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public SenderTypeUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "sendertype.updated";
    }
}
