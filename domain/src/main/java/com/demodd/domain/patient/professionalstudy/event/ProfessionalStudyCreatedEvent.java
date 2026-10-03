package com.demodd.domain.patient.professionalstudy.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ProfessionalStudyCreatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ProfessionalStudyCreatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "professionalstudy.created";
    }
}
