package com.demodd.domain.chat.chatairunerror.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatAiRunErrorStatus implements ValueObject {

    private final String value;

    public ChatAiRunErrorStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static ChatAiRunErrorStatus of(String value) {
        return new ChatAiRunErrorStatus(value);
    }

    public static ChatAiRunErrorStatus active() {
        return new ChatAiRunErrorStatus("ACTIVE");
    }

    public static ChatAiRunErrorStatus inactive() {
        return new ChatAiRunErrorStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatAiRunErrorStatus that = (ChatAiRunErrorStatus) o;
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
