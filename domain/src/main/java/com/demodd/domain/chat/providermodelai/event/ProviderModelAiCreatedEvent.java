package com.demodd.domain.chat.providermodelai.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ProviderModelAiCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ProviderModelAiCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "providermodelai.created";
    }
}
