package com.demodd.domain.chat.escalationstatus.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class EscalationStatusStatus implements ValueObject {

    private final String value;

    public EscalationStatusStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static EscalationStatusStatus of(String value) {
        return new EscalationStatusStatus(value);
    }

    public static EscalationStatusStatus active() {
        return new EscalationStatusStatus("ACTIVE");
    }

    public static EscalationStatusStatus inactive() {
        return new EscalationStatusStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EscalationStatusStatus that = (EscalationStatusStatus) o;
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
