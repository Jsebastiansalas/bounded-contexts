package com.demodd.domain.chat.chatairunmetric.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.chat.chatairunmetric.event.ChatAiRunMetricCreatedEvent;
import com.demodd.domain.chat.chatairunmetric.event.ChatAiRunMetricUpdatedEvent;
import com.demodd.domain.chat.chatairunmetric.model.valueobject.ChatAiRunMetricId;
import com.demodd.domain.chat.chatairunmetric.model.valueobject.ChatAiRunMetricName;
import com.demodd.domain.chat.chatairunmetric.model.valueobject.ChatAiRunMetricStatus;

import java.time.Instant;
import java.util.Objects;

public class ChatAiRunMetric extends AggregateRoot<ChatAiRunMetricId> {

    private final ChatAiRunMetricId id;
    private ChatAiRunMetricName name;
    private ChatAiRunMetricStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public ChatAiRunMetric(ChatAiRunMetricId id, ChatAiRunMetricName name, ChatAiRunMetricStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ChatAiRunMetricStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static ChatAiRunMetric create(ChatAiRunMetricName name) {
        ChatAiRunMetricId id = ChatAiRunMetricId.random();
        ChatAiRunMetric entity = new ChatAiRunMetric(id, name, ChatAiRunMetricStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ChatAiRunMetricCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ChatAiRunMetricName name, ChatAiRunMetricStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ChatAiRunMetricUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ChatAiRunMetricId getId() {
        return id;
    }

    public ChatAiRunMetricName getName() {
        return name;
    }

    public ChatAiRunMetricStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
