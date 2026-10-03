package com.demodd.domain.clinical.assessmenttype.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.clinical.assessmenttype.event.AssessmentTypeCreatedEvent;
import com.demodd.domain.clinical.assessmenttype.event.AssessmentTypeUpdatedEvent;
import com.demodd.domain.clinical.assessmenttype.model.valueobject.AssessmentTypeId;
import com.demodd.domain.clinical.assessmenttype.model.valueobject.AssessmentTypeName;
import com.demodd.domain.clinical.assessmenttype.model.valueobject.AssessmentTypeStatus;

import java.time.Instant;
import java.util.Objects;

public class AssessmentType extends AggregateRoot<AssessmentTypeId> {

    private final AssessmentTypeId id;
    private AssessmentTypeName name;
    private AssessmentTypeStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public AssessmentType(AssessmentTypeId id, AssessmentTypeName name, AssessmentTypeStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : AssessmentTypeStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static AssessmentType create(AssessmentTypeName name) {
        AssessmentTypeId id = AssessmentTypeId.random();
        AssessmentType entity = new AssessmentType(id, name, AssessmentTypeStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new AssessmentTypeCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(AssessmentTypeName name, AssessmentTypeStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new AssessmentTypeUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public AssessmentTypeId getId() {
        return id;
    }

    public AssessmentTypeName getName() {
        return name;
    }

    public AssessmentTypeStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
