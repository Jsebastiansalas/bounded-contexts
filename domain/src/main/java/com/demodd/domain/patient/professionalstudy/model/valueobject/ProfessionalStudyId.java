package com.demodd.domain.patient.professionalstudy.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ProfessionalStudyId implements ValueObject {

    private final UUID value;

    public ProfessionalStudyId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ProfessionalStudyId no puede ser nulo");
    }

    public static ProfessionalStudyId of(UUID value) {
        return new ProfessionalStudyId(value);
    }

    public static ProfessionalStudyId of(String value) {
        return new ProfessionalStudyId(UUID.fromString(value));
    }

    public static ProfessionalStudyId random() {
        return new ProfessionalStudyId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessionalStudyId that = (ProfessionalStudyId) o;
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
