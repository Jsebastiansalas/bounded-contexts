package com.demodd.domain.geography.relationshiptype.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record RelationshipTypeCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public RelationshipTypeCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "relationshiptype.created";
    }
}
