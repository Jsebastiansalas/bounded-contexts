package com.demodd.domain.clinical.clinicalrecordstatus.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ClinicalRecordStatusName implements ValueObject {

    private final String value;

    public ClinicalRecordStatusName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de ClinicalRecordStatusName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static ClinicalRecordStatusName of(String value) {
        return new ClinicalRecordStatusName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClinicalRecordStatusName that = (ClinicalRecordStatusName) o;
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
