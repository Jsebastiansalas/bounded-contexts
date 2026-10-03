package com.demodd.domain.chat.chatescalationassignment.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatEscalationAssignmentStatus implements ValueObject {

    private final String value;

    public ChatEscalationAssignmentStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static ChatEscalationAssignmentStatus of(String value) {
        return new ChatEscalationAssignmentStatus(value);
    }

    public static ChatEscalationAssignmentStatus active() {
        return new ChatEscalationAssignmentStatus("ACTIVE");
    }

    public static ChatEscalationAssignmentStatus inactive() {
        return new ChatEscalationAssignmentStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEscalationAssignmentStatus that = (ChatEscalationAssignmentStatus) o;
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
