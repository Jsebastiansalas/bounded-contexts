package com.demodd.domain.patient.patientallergy.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record PatientAllergyCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public PatientAllergyCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "patientallergy.created";
    }
}
