package com.demodd.domain.geography.documenttype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class DocumentTypeName implements ValueObject {

    private final String value;

    public DocumentTypeName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de DocumentTypeName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static DocumentTypeName of(String value) {
        return new DocumentTypeName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentTypeName that = (DocumentTypeName) o;
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
