package com.demodd.domain.chat.escalationstatus.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class EscalationStatusId implements ValueObject {

    private final UUID value;

    public EscalationStatusId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de EscalationStatusId no puede ser nulo");
    }

    public static EscalationStatusId of(UUID value) {
        return new EscalationStatusId(value);
    }

    public static EscalationStatusId of(String value) {
        return new EscalationStatusId(UUID.fromString(value));
    }

    public static EscalationStatusId random() {
        return new EscalationStatusId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EscalationStatusId that = (EscalationStatusId) o;
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
