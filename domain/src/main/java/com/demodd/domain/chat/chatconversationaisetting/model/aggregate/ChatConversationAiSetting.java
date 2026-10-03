package com.demodd.domain.chat.chatconversationaisetting.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.chat.chatconversationaisetting.event.ChatConversationAiSettingCreatedEvent;
import com.demodd.domain.chat.chatconversationaisetting.event.ChatConversationAiSettingUpdatedEvent;
import com.demodd.domain.chat.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;
import com.demodd.domain.chat.chatconversationaisetting.model.valueobject.ChatConversationAiSettingName;
import com.demodd.domain.chat.chatconversationaisetting.model.valueobject.ChatConversationAiSettingStatus;

import java.time.Instant;
import java.util.Objects;

public class ChatConversationAiSetting extends AggregateRoot<ChatConversationAiSettingId> {

    private final ChatConversationAiSettingId id;
    private ChatConversationAiSettingName name;
    private ChatConversationAiSettingStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public ChatConversationAiSetting(ChatConversationAiSettingId id, ChatConversationAiSettingName name, ChatConversationAiSettingStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ChatConversationAiSettingStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static ChatConversationAiSetting create(ChatConversationAiSettingName name) {
        ChatConversationAiSettingId id = ChatConversationAiSettingId.random();
        ChatConversationAiSetting entity = new ChatConversationAiSetting(id, name, ChatConversationAiSettingStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ChatConversationAiSettingCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ChatConversationAiSettingName name, ChatConversationAiSettingStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ChatConversationAiSettingUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ChatConversationAiSettingId getId() {
        return id;
    }

    public ChatConversationAiSettingName getName() {
        return name;
    }

    public ChatConversationAiSettingStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
