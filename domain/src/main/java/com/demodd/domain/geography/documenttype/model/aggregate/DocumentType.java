package com.demodd.domain.geography.documenttype.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.geography.documenttype.event.DocumentTypeCreatedEvent;
import com.demodd.domain.geography.documenttype.event.DocumentTypeUpdatedEvent;
import com.demodd.domain.geography.documenttype.model.valueobject.DocumentTypeId;
import com.demodd.domain.geography.documenttype.model.valueobject.DocumentTypeName;
import com.demodd.domain.geography.documenttype.model.valueobject.DocumentTypeStatus;

import java.time.Instant;
import java.util.Objects;

public class DocumentType extends AggregateRoot<DocumentTypeId> {

    private final DocumentTypeId id;
    private DocumentTypeName name;
    private DocumentTypeStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public DocumentType(DocumentTypeId id, DocumentTypeName name, DocumentTypeStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : DocumentTypeStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static DocumentType create(DocumentTypeName name) {
        DocumentTypeId id = DocumentTypeId.random();
        DocumentType entity = new DocumentType(id, name, DocumentTypeStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new DocumentTypeCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(DocumentTypeName name, DocumentTypeStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new DocumentTypeUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public DocumentTypeId getId() {
        return id;
    }

    public DocumentTypeName getName() {
        return name;
    }

    public DocumentTypeStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
