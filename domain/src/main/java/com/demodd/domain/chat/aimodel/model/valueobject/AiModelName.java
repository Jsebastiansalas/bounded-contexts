package com.demodd.domain.chat.aimodel.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class AiModelName implements ValueObject {

    private final String value;

    public AiModelName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de AiModelName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static AiModelName of(String value) {
        return new AiModelName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AiModelName that = (AiModelName) o;
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
