package com.demodd.domain.chat.aimodel.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class AiModelStatus implements ValueObject {

    private final String value;

    public AiModelStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static AiModelStatus of(String value) {
        return new AiModelStatus(value);
    }

    public static AiModelStatus active() {
        return new AiModelStatus("ACTIVE");
    }

    public static AiModelStatus inactive() {
        return new AiModelStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AiModelStatus that = (AiModelStatus) o;
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
