package com.demodd.domain.chat.chatescalationstatushistory.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatEscalationStatusHistoryStatus implements ValueObject {

    private final String value;

    public ChatEscalationStatusHistoryStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static ChatEscalationStatusHistoryStatus of(String value) {
        return new ChatEscalationStatusHistoryStatus(value);
    }

    public static ChatEscalationStatusHistoryStatus active() {
        return new ChatEscalationStatusHistoryStatus("ACTIVE");
    }

    public static ChatEscalationStatusHistoryStatus inactive() {
        return new ChatEscalationStatusHistoryStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEscalationStatusHistoryStatus that = (ChatEscalationStatusHistoryStatus) o;
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
