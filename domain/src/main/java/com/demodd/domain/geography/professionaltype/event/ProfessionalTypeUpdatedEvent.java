package com.demodd.domain.geography.professionaltype.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ProfessionalTypeUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ProfessionalTypeUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "professionaltype.updated";
    }
}
