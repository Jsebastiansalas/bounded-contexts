package com.demodd.domain.patient.contact.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.patient.contact.event.ContactCreatedEvent;
import com.demodd.domain.patient.contact.event.ContactUpdatedEvent;
import com.demodd.domain.patient.contact.model.valueobject.ContactId;
import com.demodd.domain.patient.contact.model.valueobject.ContactName;
import com.demodd.domain.patient.contact.model.valueobject.ContactStatus;

import java.time.Instant;
import java.util.Objects;

public class Contact extends AggregateRoot<ContactId> {

    private final ContactId id;
    private ContactName name;
    private ContactStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public Contact(ContactId id, ContactName name, ContactStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ContactStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static Contact create(ContactName name) {
        ContactId id = ContactId.random();
        Contact entity = new Contact(id, name, ContactStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ContactCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ContactName name, ContactStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ContactUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ContactId getId() {
        return id;
    }

    public ContactName getName() {
        return name;
    }

    public ContactStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
