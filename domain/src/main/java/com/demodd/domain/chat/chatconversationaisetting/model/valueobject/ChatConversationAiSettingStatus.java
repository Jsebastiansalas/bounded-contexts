package com.demodd.domain.chat.chatconversationaisetting.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatConversationAiSettingStatus implements ValueObject {

    private final String value;

    public ChatConversationAiSettingStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static ChatConversationAiSettingStatus of(String value) {
        return new ChatConversationAiSettingStatus(value);
    }

    public static ChatConversationAiSettingStatus active() {
        return new ChatConversationAiSettingStatus("ACTIVE");
    }

    public static ChatConversationAiSettingStatus inactive() {
        return new ChatConversationAiSettingStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatConversationAiSettingStatus that = (ChatConversationAiSettingStatus) o;
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
