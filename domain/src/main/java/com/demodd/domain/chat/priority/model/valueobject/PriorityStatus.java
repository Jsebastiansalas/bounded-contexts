package com.demodd.domain.chat.priority.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class PriorityStatus implements ValueObject {

    private final String value;

    public PriorityStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static PriorityStatus of(String value) {
        return new PriorityStatus(value);
    }

    public static PriorityStatus active() {
        return new PriorityStatus("ACTIVE");
    }

    public static PriorityStatus inactive() {
        return new PriorityStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriorityStatus that = (PriorityStatus) o;
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
