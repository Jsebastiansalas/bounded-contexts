package com.demodd.domain.clinical.clinicalrecordstatus.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.clinical.clinicalrecordstatus.event.ClinicalRecordStatusCreatedEvent;
import com.demodd.domain.clinical.clinicalrecordstatus.event.ClinicalRecordStatusUpdatedEvent;
import com.demodd.domain.clinical.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;
import com.demodd.domain.clinical.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusName;
import com.demodd.domain.clinical.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusStatus;

import java.time.Instant;
import java.util.Objects;

public class ClinicalRecordStatus extends AggregateRoot<ClinicalRecordStatusId> {

    private final ClinicalRecordStatusId id;
    private ClinicalRecordStatusName name;
    private ClinicalRecordStatusStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public ClinicalRecordStatus(ClinicalRecordStatusId id, ClinicalRecordStatusName name, ClinicalRecordStatusStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ClinicalRecordStatusStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static ClinicalRecordStatus create(ClinicalRecordStatusName name) {
        ClinicalRecordStatusId id = ClinicalRecordStatusId.random();
        ClinicalRecordStatus entity = new ClinicalRecordStatus(id, name, ClinicalRecordStatusStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ClinicalRecordStatusCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ClinicalRecordStatusName name, ClinicalRecordStatusStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ClinicalRecordStatusUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ClinicalRecordStatusId getId() {
        return id;
    }

    public ClinicalRecordStatusName getName() {
        return name;
    }

    public ClinicalRecordStatusStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
