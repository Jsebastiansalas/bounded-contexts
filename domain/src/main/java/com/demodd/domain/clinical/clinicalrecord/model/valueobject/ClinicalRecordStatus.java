package com.demodd.domain.clinical.clinicalrecord.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ClinicalRecordStatus implements ValueObject {

    private final String value;

    public ClinicalRecordStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static ClinicalRecordStatus of(String value) {
        return new ClinicalRecordStatus(value);
    }

    public static ClinicalRecordStatus active() {
        return new ClinicalRecordStatus("ACTIVE");
    }

    public static ClinicalRecordStatus inactive() {
        return new ClinicalRecordStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClinicalRecordStatus that = (ClinicalRecordStatus) o;
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
