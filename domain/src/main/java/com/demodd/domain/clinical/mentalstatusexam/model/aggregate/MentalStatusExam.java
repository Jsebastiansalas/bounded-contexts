package com.demodd.domain.clinical.mentalstatusexam.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.clinical.mentalstatusexam.event.MentalStatusExamCreatedEvent;
import com.demodd.domain.clinical.mentalstatusexam.event.MentalStatusExamUpdatedEvent;
import com.demodd.domain.clinical.mentalstatusexam.model.valueobject.MentalStatusExamId;
import com.demodd.domain.clinical.mentalstatusexam.model.valueobject.MentalStatusExamName;
import com.demodd.domain.clinical.mentalstatusexam.model.valueobject.MentalStatusExamStatus;

import java.time.Instant;
import java.util.Objects;

public class MentalStatusExam extends AggregateRoot<MentalStatusExamId> {

    private final MentalStatusExamId id;
    private MentalStatusExamName name;
    private MentalStatusExamStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public MentalStatusExam(MentalStatusExamId id, MentalStatusExamName name, MentalStatusExamStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : MentalStatusExamStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static MentalStatusExam create(MentalStatusExamName name) {
        MentalStatusExamId id = MentalStatusExamId.random();
        MentalStatusExam entity = new MentalStatusExam(id, name, MentalStatusExamStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new MentalStatusExamCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(MentalStatusExamName name, MentalStatusExamStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new MentalStatusExamUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public MentalStatusExamId getId() {
        return id;
    }

    public MentalStatusExamName getName() {
        return name;
    }

    public MentalStatusExamStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
