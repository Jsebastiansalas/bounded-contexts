package com.demodd.domain.clinical.clinicalnote.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ClinicalNoteStatus implements ValueObject {

    private final String value;

    public ClinicalNoteStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static ClinicalNoteStatus of(String value) {
        return new ClinicalNoteStatus(value);
    }

    public static ClinicalNoteStatus active() {
        return new ClinicalNoteStatus("ACTIVE");
    }

    public static ClinicalNoteStatus inactive() {
        return new ClinicalNoteStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClinicalNoteStatus that = (ClinicalNoteStatus) o;
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
