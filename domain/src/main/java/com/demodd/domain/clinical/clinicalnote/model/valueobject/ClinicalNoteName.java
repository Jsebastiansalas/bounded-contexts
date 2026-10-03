package com.demodd.domain.clinical.clinicalnote.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ClinicalNoteName implements ValueObject {

    private final String value;

    public ClinicalNoteName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de ClinicalNoteName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static ClinicalNoteName of(String value) {
        return new ClinicalNoteName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClinicalNoteName that = (ClinicalNoteName) o;
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
