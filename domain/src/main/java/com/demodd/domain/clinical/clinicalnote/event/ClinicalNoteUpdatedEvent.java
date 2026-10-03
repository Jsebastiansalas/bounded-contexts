package com.demodd.domain.clinical.clinicalnote.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ClinicalNoteUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ClinicalNoteUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "clinicalnote.updated";
    }
}
