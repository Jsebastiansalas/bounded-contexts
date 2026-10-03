package com.demodd.domain.chat.sendertype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class SenderTypeName implements ValueObject {

    private final String value;

    public SenderTypeName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de SenderTypeName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static SenderTypeName of(String value) {
        return new SenderTypeName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SenderTypeName that = (SenderTypeName) o;
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
