package com.demodd.domain.patient.contact.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ContactStatus implements ValueObject {

    private final String value;

    public ContactStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static ContactStatus of(String value) {
        return new ContactStatus(value);
    }

    public static ContactStatus active() {
        return new ContactStatus("ACTIVE");
    }

    public static ContactStatus inactive() {
        return new ContactStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactStatus that = (ContactStatus) o;
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
