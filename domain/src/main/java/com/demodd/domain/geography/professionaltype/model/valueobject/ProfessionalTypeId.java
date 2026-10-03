package com.demodd.domain.geography.professionaltype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ProfessionalTypeId implements ValueObject {

    private final UUID value;

    public ProfessionalTypeId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ProfessionalTypeId no puede ser nulo");
    }

    public static ProfessionalTypeId of(UUID value) {
        return new ProfessionalTypeId(value);
    }

    public static ProfessionalTypeId of(String value) {
        return new ProfessionalTypeId(UUID.fromString(value));
    }

    public static ProfessionalTypeId random() {
        return new ProfessionalTypeId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessionalTypeId that = (ProfessionalTypeId) o;
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
