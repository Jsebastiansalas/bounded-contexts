package com.demodd.domain.clinical.risklevel.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class RiskLevelId implements ValueObject {

    private final UUID value;

    public RiskLevelId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de RiskLevelId no puede ser nulo");
    }

    public static RiskLevelId of(UUID value) {
        return new RiskLevelId(value);
    }

    public static RiskLevelId of(String value) {
        return new RiskLevelId(UUID.fromString(value));
    }

    public static RiskLevelId random() {
        return new RiskLevelId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RiskLevelId that = (RiskLevelId) o;
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
