package com.demodd.domain.clinical.clinicalrecordstatus.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ClinicalRecordStatusUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ClinicalRecordStatusUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "clinicalrecordstatus.updated";
    }
}
