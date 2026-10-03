package com.demodd.domain.chat.priority.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class PriorityId implements ValueObject {

    private final UUID value;

    public PriorityId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de PriorityId no puede ser nulo");
    }

    public static PriorityId of(UUID value) {
        return new PriorityId(value);
    }

    public static PriorityId of(String value) {
        return new PriorityId(UUID.fromString(value));
    }

    public static PriorityId random() {
        return new PriorityId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriorityId that = (PriorityId) o;
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
