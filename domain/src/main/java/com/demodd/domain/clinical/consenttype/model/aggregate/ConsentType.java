package com.demodd.domain.clinical.consenttype.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.clinical.consenttype.event.ConsentTypeCreatedEvent;
import com.demodd.domain.clinical.consenttype.event.ConsentTypeUpdatedEvent;
import com.demodd.domain.clinical.consenttype.model.valueobject.ConsentTypeId;
import com.demodd.domain.clinical.consenttype.model.valueobject.ConsentTypeName;
import com.demodd.domain.clinical.consenttype.model.valueobject.ConsentTypeStatus;

import java.time.Instant;
import java.util.Objects;

public class ConsentType extends AggregateRoot<ConsentTypeId> {

    private final ConsentTypeId id;
    private ConsentTypeName name;
    private ConsentTypeStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public ConsentType(ConsentTypeId id, ConsentTypeName name, ConsentTypeStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ConsentTypeStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static ConsentType create(ConsentTypeName name) {
        ConsentTypeId id = ConsentTypeId.random();
        ConsentType entity = new ConsentType(id, name, ConsentTypeStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ConsentTypeCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ConsentTypeName name, ConsentTypeStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ConsentTypeUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ConsentTypeId getId() {
        return id;
    }

    public ConsentTypeName getName() {
        return name;
    }

    public ConsentTypeStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
