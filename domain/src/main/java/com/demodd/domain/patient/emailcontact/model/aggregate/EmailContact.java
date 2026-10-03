package com.demodd.domain.patient.emailcontact.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.patient.emailcontact.event.EmailContactCreatedEvent;
import com.demodd.domain.patient.emailcontact.event.EmailContactUpdatedEvent;
import com.demodd.domain.patient.emailcontact.model.valueobject.EmailContactId;
import com.demodd.domain.patient.emailcontact.model.valueobject.EmailContactName;
import com.demodd.domain.patient.emailcontact.model.valueobject.EmailContactStatus;

import java.time.Instant;
import java.util.Objects;

public class EmailContact extends AggregateRoot<EmailContactId> {

    private final EmailContactId id;
    private EmailContactName name;
    private EmailContactStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public EmailContact(EmailContactId id, EmailContactName name, EmailContactStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : EmailContactStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static EmailContact create(EmailContactName name) {
        EmailContactId id = EmailContactId.random();
        EmailContact entity = new EmailContact(id, name, EmailContactStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new EmailContactCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(EmailContactName name, EmailContactStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new EmailContactUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public EmailContactId getId() {
        return id;
    }

    public EmailContactName getName() {
        return name;
    }

    public EmailContactStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
