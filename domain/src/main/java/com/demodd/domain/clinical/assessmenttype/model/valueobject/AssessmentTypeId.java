package com.demodd.domain.clinical.assessmenttype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class AssessmentTypeId implements ValueObject {

    private final UUID value;

    public AssessmentTypeId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de AssessmentTypeId no puede ser nulo");
    }

    public static AssessmentTypeId of(UUID value) {
        return new AssessmentTypeId(value);
    }

    public static AssessmentTypeId of(String value) {
        return new AssessmentTypeId(UUID.fromString(value));
    }

    public static AssessmentTypeId random() {
        return new AssessmentTypeId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssessmentTypeId that = (AssessmentTypeId) o;
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
