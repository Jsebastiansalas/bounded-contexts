package com.demodd.domain.patient.professional.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ProfessionalId implements ValueObject {

    private final UUID value;

    public ProfessionalId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ProfessionalId no puede ser nulo");
    }

    public static ProfessionalId of(UUID value) {
        return new ProfessionalId(value);
    }

    public static ProfessionalId of(String value) {
        return new ProfessionalId(UUID.fromString(value));
    }

    public static ProfessionalId random() {
        return new ProfessionalId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessionalId that = (ProfessionalId) o;
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
