package com.demodd.application.chat.chatconversationaisetting.dto;

import com.demodd.domain.chat.chatconversationaisetting.model.aggregate.ChatConversationAiSetting;

import java.time.Instant;
import java.util.UUID;

public record ChatConversationAiSettingResponse(
        UUID id,
        String name,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
    public static ChatConversationAiSettingResponse fromDomain(ChatConversationAiSetting entity) {
        return new ChatConversationAiSettingResponse(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
