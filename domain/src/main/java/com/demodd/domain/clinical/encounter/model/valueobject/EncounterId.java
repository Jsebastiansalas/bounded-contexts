package com.demodd.domain.clinical.encounter.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class EncounterId implements ValueObject {

    private final UUID value;

    public EncounterId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de EncounterId no puede ser nulo");
    }

    public static EncounterId of(UUID value) {
        return new EncounterId(value);
    }

    public static EncounterId of(String value) {
        return new EncounterId(UUID.fromString(value));
    }

    public static EncounterId random() {
        return new EncounterId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncounterId that = (EncounterId) o;
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
