package com.demodd.domain.chat.chatairun.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatAiRunStatus implements ValueObject {

    private final String value;

    public ChatAiRunStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static ChatAiRunStatus of(String value) {
        return new ChatAiRunStatus(value);
    }

    public static ChatAiRunStatus active() {
        return new ChatAiRunStatus("ACTIVE");
    }

    public static ChatAiRunStatus inactive() {
        return new ChatAiRunStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatAiRunStatus that = (ChatAiRunStatus) o;
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
