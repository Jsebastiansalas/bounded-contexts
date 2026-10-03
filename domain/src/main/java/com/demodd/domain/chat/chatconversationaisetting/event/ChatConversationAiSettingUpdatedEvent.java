package com.demodd.domain.chat.chatconversationaisetting.event;

import com.demodd.domain.common.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record ChatConversationAiSettingUpdatedEvent(UUID aggregateId, Instant occurredOn) implements DomainEvent {

    public ChatConversationAiSettingUpdatedEvent(UUID aggregateId) {
        this(aggregateId, Instant.now());
    }

    @Override
    public String eventType() {
        return "chatconversationaisetting.updated";
    }
}
