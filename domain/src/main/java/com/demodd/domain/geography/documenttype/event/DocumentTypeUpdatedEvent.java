package com.demodd.domain.geography.documenttype.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record DocumentTypeUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public DocumentTypeUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "documenttype.updated";
    }
}
