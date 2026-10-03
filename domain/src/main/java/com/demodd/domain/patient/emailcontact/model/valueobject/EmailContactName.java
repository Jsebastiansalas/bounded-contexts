package com.demodd.domain.patient.emailcontact.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class EmailContactName implements ValueObject {

    private final String value;

    public EmailContactName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de EmailContactName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static EmailContactName of(String value) {
        return new EmailContactName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailContactName that = (EmailContactName) o;
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
