package com.demodd.domain.patient.phonecontact.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.patient.phonecontact.event.PhoneContactCreatedEvent;
import com.demodd.domain.patient.phonecontact.event.PhoneContactUpdatedEvent;
import com.demodd.domain.patient.phonecontact.model.valueobject.PhoneContactId;
import com.demodd.domain.patient.phonecontact.model.valueobject.PhoneContactName;
import com.demodd.domain.patient.phonecontact.model.valueobject.PhoneContactStatus;

import java.time.Instant;
import java.util.Objects;

public class PhoneContact extends AggregateRoot<PhoneContactId> {

    private final PhoneContactId id;
    private PhoneContactName name;
    private PhoneContactStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public PhoneContact(PhoneContactId id, PhoneContactName name, PhoneContactStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : PhoneContactStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static PhoneContact create(PhoneContactName name) {
        PhoneContactId id = PhoneContactId.random();
        PhoneContact entity = new PhoneContact(id, name, PhoneContactStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new PhoneContactCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(PhoneContactName name, PhoneContactStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new PhoneContactUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public PhoneContactId getId() {
        return id;
    }

    public PhoneContactName getName() {
        return name;
    }

    public PhoneContactStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
