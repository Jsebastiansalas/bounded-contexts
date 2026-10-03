package com.demodd.domain.chat.airunstatus.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class AiRunStatusId implements ValueObject {

    private final UUID value;

    public AiRunStatusId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de AiRunStatusId no puede ser nulo");
    }

    public static AiRunStatusId of(UUID value) {
        return new AiRunStatusId(value);
    }

    public static AiRunStatusId of(String value) {
        return new AiRunStatusId(UUID.fromString(value));
    }

    public static AiRunStatusId random() {
        return new AiRunStatusId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AiRunStatusId that = (AiRunStatusId) o;
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
