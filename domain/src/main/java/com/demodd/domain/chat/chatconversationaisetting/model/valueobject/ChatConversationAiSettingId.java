package com.demodd.domain.chat.chatconversationaisetting.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ChatConversationAiSettingId implements ValueObject {

    private final UUID value;

    public ChatConversationAiSettingId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ChatConversationAiSettingId no puede ser nulo");
    }

    public static ChatConversationAiSettingId of(UUID value) {
        return new ChatConversationAiSettingId(value);
    }

    public static ChatConversationAiSettingId of(String value) {
        return new ChatConversationAiSettingId(UUID.fromString(value));
    }

    public static ChatConversationAiSettingId random() {
        return new ChatConversationAiSettingId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatConversationAiSettingId that = (ChatConversationAiSettingId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
