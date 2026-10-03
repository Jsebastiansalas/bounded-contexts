package com.demodd.domain.clinical.riskassessment.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.clinical.riskassessment.event.RiskAssessmentCreatedEvent;
import com.demodd.domain.clinical.riskassessment.event.RiskAssessmentUpdatedEvent;
import com.demodd.domain.clinical.riskassessment.model.valueobject.RiskAssessmentId;
import com.demodd.domain.clinical.riskassessment.model.valueobject.RiskAssessmentName;
import com.demodd.domain.clinical.riskassessment.model.valueobject.RiskAssessmentStatus;

import java.time.Instant;
import java.util.Objects;

public class RiskAssessment extends AggregateRoot<RiskAssessmentId> {

    private final RiskAssessmentId id;
    private RiskAssessmentName name;
    private RiskAssessmentStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public RiskAssessment(RiskAssessmentId id, RiskAssessmentName name, RiskAssessmentStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : RiskAssessmentStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static RiskAssessment create(RiskAssessmentName name) {
        RiskAssessmentId id = RiskAssessmentId.random();
        RiskAssessment entity = new RiskAssessment(id, name, RiskAssessmentStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new RiskAssessmentCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(RiskAssessmentName name, RiskAssessmentStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new RiskAssessmentUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public RiskAssessmentId getId() {
        return id;
    }

    public RiskAssessmentName getName() {
        return name;
    }

    public RiskAssessmentStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
