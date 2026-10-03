package com.demodd.domain.patient.patientallergy.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class PatientAllergyName implements ValueObject {

    private final String value;

    public PatientAllergyName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de PatientAllergyName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static PatientAllergyName of(String value) {
        return new PatientAllergyName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientAllergyName that = (PatientAllergyName) o;
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
