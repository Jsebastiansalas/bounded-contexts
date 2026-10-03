package com.demodd.domain.clinical.clinicalrecord.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ClinicalRecordUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ClinicalRecordUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "clinicalrecord.updated";
    }
}
