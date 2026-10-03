package com.demodd.domain.chat.aimodel.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class AiModelId implements ValueObject {

    private final UUID value;

    public AiModelId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de AiModelId no puede ser nulo");
    }

    public static AiModelId of(UUID value) {
        return new AiModelId(value);
    }

    public static AiModelId of(String value) {
        return new AiModelId(UUID.fromString(value));
    }

    public static AiModelId random() {
        return new AiModelId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AiModelId that = (AiModelId) o;
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
