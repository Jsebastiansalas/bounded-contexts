package com.demodd.domain.chat.chatconversationaisetting.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatConversationAiSettingName implements ValueObject {

    private final String value;

    public ChatConversationAiSettingName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de ChatConversationAiSettingName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static ChatConversationAiSettingName of(String value) {
        return new ChatConversationAiSettingName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatConversationAiSettingName that = (ChatConversationAiSettingName) o;
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
