package com.demodd.domain.chat.providermodelai.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ProviderModelAiUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ProviderModelAiUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "providermodelai.updated";
    }
}
