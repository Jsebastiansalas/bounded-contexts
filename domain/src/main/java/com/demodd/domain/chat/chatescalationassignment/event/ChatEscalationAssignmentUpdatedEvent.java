package com.demodd.domain.chat.chatescalationassignment.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ChatEscalationAssignmentUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ChatEscalationAssignmentUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "chatescalationassignment.updated";
    }
}
