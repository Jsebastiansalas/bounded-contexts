package com.demodd.domain.clinical.diagnosticsystem.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.clinical.diagnosticsystem.event.DiagnosticSystemCreatedEvent;
import com.demodd.domain.clinical.diagnosticsystem.event.DiagnosticSystemUpdatedEvent;
import com.demodd.domain.clinical.diagnosticsystem.model.valueobject.DiagnosticSystemId;
import com.demodd.domain.clinical.diagnosticsystem.model.valueobject.DiagnosticSystemName;
import com.demodd.domain.clinical.diagnosticsystem.model.valueobject.DiagnosticSystemStatus;

import java.time.Instant;
import java.util.Objects;

public class DiagnosticSystem extends AggregateRoot<DiagnosticSystemId> {

    private final DiagnosticSystemId id;
    private DiagnosticSystemName name;
    private DiagnosticSystemStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public DiagnosticSystem(DiagnosticSystemId id, DiagnosticSystemName name, DiagnosticSystemStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : DiagnosticSystemStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static DiagnosticSystem create(DiagnosticSystemName name) {
        DiagnosticSystemId id = DiagnosticSystemId.random();
        DiagnosticSystem entity = new DiagnosticSystem(id, name, DiagnosticSystemStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new DiagnosticSystemCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(DiagnosticSystemName name, DiagnosticSystemStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new DiagnosticSystemUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public DiagnosticSystemId getId() {
        return id;
    }

    public DiagnosticSystemName getName() {
        return name;
    }

    public DiagnosticSystemStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
