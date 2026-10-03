package com.demodd.domain.clinical.clinicalnote.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ClinicalNoteCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ClinicalNoteCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "clinicalnote.created";
    }
}
