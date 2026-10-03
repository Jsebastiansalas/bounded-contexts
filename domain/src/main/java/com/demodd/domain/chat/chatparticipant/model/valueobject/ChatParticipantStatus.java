package com.demodd.domain.chat.chatparticipant.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatParticipantStatus implements ValueObject {

    private final String value;

    public ChatParticipantStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static ChatParticipantStatus of(String value) {
        return new ChatParticipantStatus(value);
    }

    public static ChatParticipantStatus active() {
        return new ChatParticipantStatus("ACTIVE");
    }

    public static ChatParticipantStatus inactive() {
        return new ChatParticipantStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatParticipantStatus that = (ChatParticipantStatus) o;
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
