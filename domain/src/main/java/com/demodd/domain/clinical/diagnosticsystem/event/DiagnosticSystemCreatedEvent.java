package com.demodd.domain.clinical.diagnosticsystem.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record DiagnosticSystemCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public DiagnosticSystemCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "diagnosticsystem.created";
    }
}
