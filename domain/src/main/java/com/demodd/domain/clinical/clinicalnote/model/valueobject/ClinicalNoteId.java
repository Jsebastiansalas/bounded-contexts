package com.demodd.domain.clinical.clinicalnote.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ClinicalNoteId implements ValueObject {

    private final UUID value;

    public ClinicalNoteId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ClinicalNoteId no puede ser nulo");
    }

    public static ClinicalNoteId of(UUID value) {
        return new ClinicalNoteId(value);
    }

    public static ClinicalNoteId of(String value) {
        return new ClinicalNoteId(UUID.fromString(value));
    }

    public static ClinicalNoteId random() {
        return new ClinicalNoteId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClinicalNoteId that = (ClinicalNoteId) o;
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
