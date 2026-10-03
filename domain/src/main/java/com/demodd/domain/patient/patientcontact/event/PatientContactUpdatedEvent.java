package com.demodd.domain.patient.patientcontact.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record PatientContactUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public PatientContactUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "patientcontact.updated";
    }
}
