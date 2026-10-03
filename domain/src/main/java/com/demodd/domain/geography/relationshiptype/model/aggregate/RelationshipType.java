package com.demodd.domain.geography.relationshiptype.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.geography.relationshiptype.event.RelationshipTypeCreatedEvent;
import com.demodd.domain.geography.relationshiptype.event.RelationshipTypeUpdatedEvent;
import com.demodd.domain.geography.relationshiptype.model.valueobject.RelationshipTypeId;
import com.demodd.domain.geography.relationshiptype.model.valueobject.RelationshipTypeName;
import com.demodd.domain.geography.relationshiptype.model.valueobject.RelationshipTypeStatus;

import java.time.Instant;
import java.util.Objects;

public class RelationshipType extends AggregateRoot<RelationshipTypeId> {

    private final RelationshipTypeId id;
    private RelationshipTypeName name;
    private RelationshipTypeStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public RelationshipType(RelationshipTypeId id, RelationshipTypeName name, RelationshipTypeStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : RelationshipTypeStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static RelationshipType create(RelationshipTypeName name) {
        RelationshipTypeId id = RelationshipTypeId.random();
        RelationshipType entity = new RelationshipType(id, name, RelationshipTypeStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new RelationshipTypeCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(RelationshipTypeName name, RelationshipTypeStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new RelationshipTypeUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public RelationshipTypeId getId() {
        return id;
    }

    public RelationshipTypeName getName() {
        return name;
    }

    public RelationshipTypeStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
