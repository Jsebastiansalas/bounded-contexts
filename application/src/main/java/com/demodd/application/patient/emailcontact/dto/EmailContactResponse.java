package com.demodd.application.patient.emailcontact.dto;

import com.demodd.domain.patient.emailcontact.model.aggregate.EmailContact;

import java.time.Instant;
import java.util.UUID;

public record EmailContactResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static EmailContactResponse fromDomain(EmailContact entity) {
        return new EmailContactResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
