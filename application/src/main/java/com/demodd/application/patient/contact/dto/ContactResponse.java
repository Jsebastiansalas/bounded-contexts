package com.demodd.application.patient.contact.dto;

import com.demodd.domain.patient.contact.model.aggregate.Contact;

import java.time.Instant;
import java.util.UUID;

public record ContactResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ContactResponse fromDomain(Contact entity) {
        return new ContactResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
