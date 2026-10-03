package com.demodd.domain.chat.chatescalationassignment.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ChatEscalationAssignmentCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ChatEscalationAssignmentCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "chatescalationassignment.created";
    }
}
