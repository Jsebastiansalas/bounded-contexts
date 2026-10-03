package com.demodd.domain.patient.patientallergy.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class PatientAllergyStatus implements ValueObject {

    private final String value;

    public PatientAllergyStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static PatientAllergyStatus of(String value) {
        return new PatientAllergyStatus(value);
    }

    public static PatientAllergyStatus active() {
        return new PatientAllergyStatus("ACTIVE");
    }

    public static PatientAllergyStatus inactive() {
        return new PatientAllergyStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientAllergyStatus that = (PatientAllergyStatus) o;
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
