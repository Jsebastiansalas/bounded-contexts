package com.demodd.domain.patient.phonecontact.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class PhoneContactStatus implements ValueObject {

    private final String value;

    public PhoneContactStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static PhoneContactStatus of(String value) {
        return new PhoneContactStatus(value);
    }

    public static PhoneContactStatus active() {
        return new PhoneContactStatus("ACTIVE");
    }

    public static PhoneContactStatus inactive() {
        return new PhoneContactStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneContactStatus that = (PhoneContactStatus) o;
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
