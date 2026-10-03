package com.demodd.domain.clinical.diagnosticsystem.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record DiagnosticSystemUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public DiagnosticSystemUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "diagnosticsystem.updated";
    }
}
