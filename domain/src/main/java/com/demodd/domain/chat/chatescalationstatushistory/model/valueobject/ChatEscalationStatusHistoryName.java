package com.demodd.domain.chat.chatescalationstatushistory.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatEscalationStatusHistoryName implements ValueObject {

    private final String value;

    public ChatEscalationStatusHistoryName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de ChatEscalationStatusHistoryName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static ChatEscalationStatusHistoryName of(String value) {
        return new ChatEscalationStatusHistoryName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEscalationStatusHistoryName that = (ChatEscalationStatusHistoryName) o;
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
