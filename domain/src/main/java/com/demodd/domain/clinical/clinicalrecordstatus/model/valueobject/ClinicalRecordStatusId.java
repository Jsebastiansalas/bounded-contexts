package com.demodd.domain.clinical.clinicalrecordstatus.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ClinicalRecordStatusId implements ValueObject {

    private final UUID value;

    public ClinicalRecordStatusId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ClinicalRecordStatusId no puede ser nulo");
    }

    public static ClinicalRecordStatusId of(UUID value) {
        return new ClinicalRecordStatusId(value);
    }

    public static ClinicalRecordStatusId of(String value) {
        return new ClinicalRecordStatusId(UUID.fromString(value));
    }

    public static ClinicalRecordStatusId random() {
        return new ClinicalRecordStatusId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClinicalRecordStatusId that = (ClinicalRecordStatusId) o;
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
