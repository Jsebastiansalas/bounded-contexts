package com.demodd.domain.clinical.mentalstatusexam.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class MentalStatusExamName implements ValueObject {

    private final String value;

    public MentalStatusExamName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de MentalStatusExamName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static MentalStatusExamName of(String value) {
        return new MentalStatusExamName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MentalStatusExamName that = (MentalStatusExamName) o;
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
