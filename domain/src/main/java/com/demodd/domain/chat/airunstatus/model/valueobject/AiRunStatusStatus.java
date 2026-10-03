package com.demodd.domain.chat.airunstatus.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class AiRunStatusStatus implements ValueObject {

    private final String value;

    public AiRunStatusStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static AiRunStatusStatus of(String value) {
        return new AiRunStatusStatus(value);
    }

    public static AiRunStatusStatus active() {
        return new AiRunStatusStatus("ACTIVE");
    }

    public static AiRunStatusStatus inactive() {
        return new AiRunStatusStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AiRunStatusStatus that = (AiRunStatusStatus) o;
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
