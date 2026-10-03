package com.demodd.domain.patient.professional.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.patient.professional.event.ProfessionalCreatedEvent;
import com.demodd.domain.patient.professional.event.ProfessionalUpdatedEvent;
import com.demodd.domain.patient.professional.model.valueobject.ProfessionalId;
import com.demodd.domain.patient.professional.model.valueobject.ProfessionalName;
import com.demodd.domain.patient.professional.model.valueobject.ProfessionalStatus;

import java.time.Instant;
import java.util.Objects;

public class Professional extends AggregateRoot<ProfessionalId> {

    private final ProfessionalId id;
    private ProfessionalName name;
    private ProfessionalStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public Professional(ProfessionalId id, ProfessionalName name, ProfessionalStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ProfessionalStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static Professional create(ProfessionalName name) {
        ProfessionalId id = ProfessionalId.random();
        Professional entity = new Professional(id, name, ProfessionalStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ProfessionalCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ProfessionalName name, ProfessionalStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ProfessionalUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ProfessionalId getId() {
        return id;
    }

    public ProfessionalName getName() {
        return name;
    }

    public ProfessionalStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
