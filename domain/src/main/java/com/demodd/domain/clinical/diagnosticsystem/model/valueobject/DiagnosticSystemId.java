package com.demodd.domain.clinical.diagnosticsystem.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class DiagnosticSystemId implements ValueObject {

    private final UUID value;

    public DiagnosticSystemId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de DiagnosticSystemId no puede ser nulo");
    }

    public static DiagnosticSystemId of(UUID value) {
        return new DiagnosticSystemId(value);
    }

    public static DiagnosticSystemId of(String value) {
        return new DiagnosticSystemId(UUID.fromString(value));
    }

    public static DiagnosticSystemId random() {
        return new DiagnosticSystemId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiagnosticSystemId that = (DiagnosticSystemId) o;
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
