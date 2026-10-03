package com.demodd.domain.geography.relationshiptype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class RelationshipTypeName implements ValueObject {

    private final String value;

    public RelationshipTypeName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de RelationshipTypeName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static RelationshipTypeName of(String value) {
        return new RelationshipTypeName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelationshipTypeName that = (RelationshipTypeName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
