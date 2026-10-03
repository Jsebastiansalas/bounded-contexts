package com.demodd.domain.chat.chatairunmetric.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ChatAiRunMetricUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ChatAiRunMetricUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "chatairunmetric.updated";
    }
}
