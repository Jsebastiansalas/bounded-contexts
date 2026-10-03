package com.demodd.domain.patient.emailcontact.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class EmailContactStatus implements ValueObject {

    private final String value;

    public EmailContactStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static EmailContactStatus of(String value) {
        return new EmailContactStatus(value);
    }

    public static EmailContactStatus active() {
        return new EmailContactStatus("ACTIVE");
    }

    public static EmailContactStatus inactive() {
        return new EmailContactStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailContactStatus that = (EmailContactStatus) o;
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
