package com.demodd.domain.chat.chatmessage.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatMessageStatus implements ValueObject {

    private final String value;

    public ChatMessageStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static ChatMessageStatus of(String value) {
        return new ChatMessageStatus(value);
    }

    public static ChatMessageStatus active() {
        return new ChatMessageStatus("ACTIVE");
    }

    public static ChatMessageStatus inactive() {
        return new ChatMessageStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatMessageStatus that = (ChatMessageStatus) o;
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
