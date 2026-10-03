package com.demodd.domain.chat.chatescalationassignment.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatEscalationAssignmentName implements ValueObject {

    private final String value;

    public ChatEscalationAssignmentName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de ChatEscalationAssignmentName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static ChatEscalationAssignmentName of(String value) {
        return new ChatEscalationAssignmentName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEscalationAssignmentName that = (ChatEscalationAssignmentName) o;
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
