package com.demodd.domain.clinical.consenttype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ConsentTypeId implements ValueObject {

    private final UUID value;

    public ConsentTypeId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ConsentTypeId no puede ser nulo");
    }

    public static ConsentTypeId of(UUID value) {
        return new ConsentTypeId(value);
    }

    public static ConsentTypeId of(String value) {
        return new ConsentTypeId(UUID.fromString(value));
    }

    public static ConsentTypeId random() {
        return new ConsentTypeId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsentTypeId that = (ConsentTypeId) o;
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
