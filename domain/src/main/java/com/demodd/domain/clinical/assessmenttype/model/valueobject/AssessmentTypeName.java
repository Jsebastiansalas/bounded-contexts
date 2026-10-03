package com.demodd.domain.clinical.assessmenttype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class AssessmentTypeName implements ValueObject {

    private final String value;

    public AssessmentTypeName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de AssessmentTypeName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static AssessmentTypeName of(String value) {
        return new AssessmentTypeName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssessmentTypeName that = (AssessmentTypeName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
