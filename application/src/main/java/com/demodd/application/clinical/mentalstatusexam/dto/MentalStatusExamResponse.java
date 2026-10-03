package com.demodd.application.clinical.mentalstatusexam.dto;

import com.demodd.domain.clinical.mentalstatusexam.model.aggregate.MentalStatusExam;

import java.time.Instant;
import java.util.UUID;

public record MentalStatusExamResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static MentalStatusExamResponse fromDomain(MentalStatusExam entity) {
        return new MentalStatusExamResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
