package com.demodd.domain.chat.chatparticipant.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ChatParticipantUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ChatParticipantUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "chatparticipant.updated";
    }
}
