package com.demodd.domain.geography.relationshiptype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class RelationshipTypeStatus implements ValueObject {

    private final String value;

    public RelationshipTypeStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static RelationshipTypeStatus of(String value) {
        return new RelationshipTypeStatus(value);
    }

    public static RelationshipTypeStatus active() {
        return new RelationshipTypeStatus("ACTIVE");
    }

    public static RelationshipTypeStatus inactive() {
        return new RelationshipTypeStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelationshipTypeStatus that = (RelationshipTypeStatus) o;
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
