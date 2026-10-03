package com.demodd.domain.geography.documenttype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class DocumentTypeStatus implements ValueObject {

    private final String value;

    public DocumentTypeStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static DocumentTypeStatus of(String value) {
        return new DocumentTypeStatus(value);
    }

    public static DocumentTypeStatus active() {
        return new DocumentTypeStatus("ACTIVE");
    }

    public static DocumentTypeStatus inactive() {
        return new DocumentTypeStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentTypeStatus that = (DocumentTypeStatus) o;
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
