package com.demodd.domain.geography.relationshiptype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class RelationshipTypeId implements ValueObject {

    private final UUID value;

    public RelationshipTypeId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de RelationshipTypeId no puede ser nulo");
    }

    public static RelationshipTypeId of(UUID value) {
        return new RelationshipTypeId(value);
    }

    public static RelationshipTypeId of(String value) {
        return new RelationshipTypeId(UUID.fromString(value));
    }

    public static RelationshipTypeId random() {
        return new RelationshipTypeId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelationshipTypeId that = (RelationshipTypeId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
