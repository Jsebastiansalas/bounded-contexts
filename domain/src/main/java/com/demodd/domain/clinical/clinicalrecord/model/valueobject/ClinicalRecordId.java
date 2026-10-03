package com.demodd.domain.clinical.clinicalrecord.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ClinicalRecordId implements ValueObject {

    private final UUID value;

    public ClinicalRecordId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ClinicalRecordId no puede ser nulo");
    }

    public static ClinicalRecordId of(UUID value) {
        return new ClinicalRecordId(value);
    }

    public static ClinicalRecordId of(String value) {
        return new ClinicalRecordId(UUID.fromString(value));
    }

    public static ClinicalRecordId random() {
        return new ClinicalRecordId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClinicalRecordId that = (ClinicalRecordId) o;
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
