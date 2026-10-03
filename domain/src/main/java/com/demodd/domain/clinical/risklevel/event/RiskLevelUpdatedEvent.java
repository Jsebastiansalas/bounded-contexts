package com.demodd.domain.clinical.risklevel.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record RiskLevelUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public RiskLevelUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "risklevel.updated";
    }
}
