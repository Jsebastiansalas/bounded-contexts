package com.demodd.domain.geography.documenttype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class DocumentTypeId implements ValueObject {

    private final UUID value;

    public DocumentTypeId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de DocumentTypeId no puede ser nulo");
    }

    public static DocumentTypeId of(UUID value) {
        return new DocumentTypeId(value);
    }

    public static DocumentTypeId of(String value) {
        return new DocumentTypeId(UUID.fromString(value));
    }

    public static DocumentTypeId random() {
        return new DocumentTypeId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentTypeId that = (DocumentTypeId) o;
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
