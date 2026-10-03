package com.demodd.domain.geography.gender.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class GenderId implements ValueObject {

    private final UUID value;

    public GenderId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de GenderId no puede ser nulo");
    }

    public static GenderId of(UUID value) {
        return new GenderId(value);
    }

    public static GenderId of(String value) {
        return new GenderId(UUID.fromString(value));
    }

    public static GenderId random() {
        return new GenderId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenderId that = (GenderId) o;
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
