package com.demodd.domain.clinical.clinicalrecord.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.clinical.clinicalrecord.event.ClinicalRecordCreatedEvent;
import com.demodd.domain.clinical.clinicalrecord.event.ClinicalRecordUpdatedEvent;
import com.demodd.domain.clinical.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.demodd.domain.clinical.clinicalrecord.model.valueobject.ClinicalRecordName;
import com.demodd.domain.clinical.clinicalrecord.model.valueobject.ClinicalRecordStatus;

import java.time.Instant;
import java.util.Objects;

public class ClinicalRecord extends AggregateRoot<ClinicalRecordId> {

    private final ClinicalRecordId id;
    private ClinicalRecordName name;
    private ClinicalRecordStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public ClinicalRecord(ClinicalRecordId id, ClinicalRecordName name, ClinicalRecordStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ClinicalRecordStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static ClinicalRecord create(ClinicalRecordName name) {
        ClinicalRecordId id = ClinicalRecordId.random();
        ClinicalRecord entity = new ClinicalRecord(id, name, ClinicalRecordStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ClinicalRecordCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ClinicalRecordName name, ClinicalRecordStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ClinicalRecordUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ClinicalRecordId getId() {
        return id;
    }

    public ClinicalRecordName getName() {
        return name;
    }

    public ClinicalRecordStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
