package com.demodd.domain.geography.relationshiptype.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record RelationshipTypeUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public RelationshipTypeUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "relationshiptype.updated";
    }
}
