package com.demodd.domain.chat.chatescalation.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatEscalationStatus implements ValueObject {

    private final String value;

    public ChatEscalationStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static ChatEscalationStatus of(String value) {
        return new ChatEscalationStatus(value);
    }

    public static ChatEscalationStatus active() {
        return new ChatEscalationStatus("ACTIVE");
    }

    public static ChatEscalationStatus inactive() {
        return new ChatEscalationStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEscalationStatus that = (ChatEscalationStatus) o;
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
