package com.demodd.domain.chat.chatescalation.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatEscalationName implements ValueObject {

    private final String value;

    public ChatEscalationName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de ChatEscalationName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static ChatEscalationName of(String value) {
        return new ChatEscalationName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEscalationName that = (ChatEscalationName) o;
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
