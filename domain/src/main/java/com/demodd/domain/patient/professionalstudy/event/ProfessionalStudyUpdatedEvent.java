package com.demodd.domain.patient.professionalstudy.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ProfessionalStudyUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ProfessionalStudyUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "professionalstudy.updated";
    }
}
