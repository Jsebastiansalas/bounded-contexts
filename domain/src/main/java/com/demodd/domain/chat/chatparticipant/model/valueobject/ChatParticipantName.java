package com.demodd.domain.chat.chatparticipant.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatParticipantName implements ValueObject {

    private final String value;

    public ChatParticipantName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de ChatParticipantName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static ChatParticipantName of(String value) {
        return new ChatParticipantName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatParticipantName that = (ChatParticipantName) o;
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
