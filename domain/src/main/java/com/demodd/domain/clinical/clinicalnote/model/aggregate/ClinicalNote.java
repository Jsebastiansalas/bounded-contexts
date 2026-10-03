package com.demodd.domain.clinical.clinicalnote.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.clinical.clinicalnote.event.ClinicalNoteCreatedEvent;
import com.demodd.domain.clinical.clinicalnote.event.ClinicalNoteUpdatedEvent;
import com.demodd.domain.clinical.clinicalnote.model.valueobject.ClinicalNoteId;
import com.demodd.domain.clinical.clinicalnote.model.valueobject.ClinicalNoteName;
import com.demodd.domain.clinical.clinicalnote.model.valueobject.ClinicalNoteStatus;

import java.time.Instant;
import java.util.Objects;

public class ClinicalNote extends AggregateRoot<ClinicalNoteId> {

    private final ClinicalNoteId id;
    private ClinicalNoteName name;
    private ClinicalNoteStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public ClinicalNote(ClinicalNoteId id, ClinicalNoteName name, ClinicalNoteStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ClinicalNoteStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static ClinicalNote create(ClinicalNoteName name) {
        ClinicalNoteId id = ClinicalNoteId.random();
        ClinicalNote entity = new ClinicalNote(id, name, ClinicalNoteStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ClinicalNoteCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ClinicalNoteName name, ClinicalNoteStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ClinicalNoteUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ClinicalNoteId getId() {
        return id;
    }

    public ClinicalNoteName getName() {
        return name;
    }

    public ClinicalNoteStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
