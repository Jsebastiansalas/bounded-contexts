package com.demodd.domain.geography.professionaltype.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.geography.professionaltype.event.ProfessionalTypeCreatedEvent;
import com.demodd.domain.geography.professionaltype.event.ProfessionalTypeUpdatedEvent;
import com.demodd.domain.geography.professionaltype.model.valueobject.ProfessionalTypeId;
import com.demodd.domain.geography.professionaltype.model.valueobject.ProfessionalTypeName;
import com.demodd.domain.geography.professionaltype.model.valueobject.ProfessionalTypeStatus;

import java.time.Instant;
import java.util.Objects;

public class ProfessionalType extends AggregateRoot<ProfessionalTypeId> {

    private final ProfessionalTypeId id;
    private ProfessionalTypeName name;
    private ProfessionalTypeStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public ProfessionalType(ProfessionalTypeId id, ProfessionalTypeName name, ProfessionalTypeStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ProfessionalTypeStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static ProfessionalType create(ProfessionalTypeName name) {
        ProfessionalTypeId id = ProfessionalTypeId.random();
        ProfessionalType entity = new ProfessionalType(id, name, ProfessionalTypeStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ProfessionalTypeCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ProfessionalTypeName name, ProfessionalTypeStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ProfessionalTypeUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ProfessionalTypeId getId() {
        return id;
    }

    public ProfessionalTypeName getName() {
        return name;
    }

    public ProfessionalTypeStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
