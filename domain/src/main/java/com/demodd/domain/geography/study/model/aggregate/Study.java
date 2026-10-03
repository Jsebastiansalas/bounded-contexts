package com.demodd.domain.geography.study.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.geography.study.event.StudyCreatedEvent;
import com.demodd.domain.geography.study.event.StudyUpdatedEvent;
import com.demodd.domain.geography.study.model.valueobject.StudyId;
import com.demodd.domain.geography.study.model.valueobject.StudyName;
import com.demodd.domain.geography.study.model.valueobject.StudyStatus;

import java.time.Instant;
import java.util.Objects;

public class Study extends AggregateRoot<StudyId> {

    private final StudyId id;
    private StudyName name;
    private StudyStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public Study(StudyId id, StudyName name, StudyStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : StudyStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static Study create(StudyName name) {
        StudyId id = StudyId.random();
        Study entity = new Study(id, name, StudyStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new StudyCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(StudyName name, StudyStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new StudyUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public StudyId getId() {
        return id;
    }

    public StudyName getName() {
        return name;
    }

    public StudyStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
