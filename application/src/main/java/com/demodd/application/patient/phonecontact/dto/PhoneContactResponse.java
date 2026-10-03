package com.demodd.application.patient.phonecontact.dto;

import com.demodd.domain.patient.phonecontact.model.aggregate.PhoneContact;

import java.time.Instant;
import java.util.UUID;

public record PhoneContactResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static PhoneContactResponse fromDomain(PhoneContact entity) {
        return new PhoneContactResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
