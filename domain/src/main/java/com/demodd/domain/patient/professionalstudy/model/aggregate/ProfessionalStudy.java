package com.demodd.domain.patient.professionalstudy.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.patient.professionalstudy.event.ProfessionalStudyCreatedEvent;
import com.demodd.domain.patient.professionalstudy.event.ProfessionalStudyUpdatedEvent;
import com.demodd.domain.patient.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.demodd.domain.patient.professionalstudy.model.valueobject.ProfessionalStudyName;
import com.demodd.domain.patient.professionalstudy.model.valueobject.ProfessionalStudyStatus;

import java.time.Instant;
import java.util.Objects;

public class ProfessionalStudy extends AggregateRoot<ProfessionalStudyId> {

    private final ProfessionalStudyId id;
    private ProfessionalStudyName name;
    private ProfessionalStudyStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public ProfessionalStudy(ProfessionalStudyId id, ProfessionalStudyName name, ProfessionalStudyStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ProfessionalStudyStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static ProfessionalStudy create(ProfessionalStudyName name) {
        ProfessionalStudyId id = ProfessionalStudyId.random();
        ProfessionalStudy entity = new ProfessionalStudy(id, name, ProfessionalStudyStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ProfessionalStudyCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ProfessionalStudyName name, ProfessionalStudyStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ProfessionalStudyUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ProfessionalStudyId getId() {
        return id;
    }

    public ProfessionalStudyName getName() {
        return name;
    }

    public ProfessionalStudyStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
