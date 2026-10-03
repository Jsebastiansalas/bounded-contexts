package com.demodd.application.chat.chatairunmetric.service;

import com.demodd.application.chat.chatairunmetric.dto.ChatAiRunMetricResponse;
import com.demodd.application.chat.chatairunmetric.port.in.CreateChatAiRunMetricUseCase;
import com.demodd.application.chat.chatairunmetric.port.in.DeleteChatAiRunMetricUseCase;
import com.demodd.application.chat.chatairunmetric.port.in.GetChatAiRunMetricUseCase;
import com.demodd.application.chat.chatairunmetric.port.in.UpdateChatAiRunMetricUseCase;
import com.demodd.domain.chat.chatairunmetric.exception.ChatAiRunMetricNotFoundException;
import com.demodd.domain.chat.chatairunmetric.model.aggregate.ChatAiRunMetric;
import com.demodd.domain.chat.chatairunmetric.model.valueobject.ChatAiRunMetricId;
import com.demodd.domain.chat.chatairunmetric.model.valueobject.ChatAiRunMetricName;
import com.demodd.domain.chat.chatairunmetric.model.valueobject.ChatAiRunMetricStatus;
import com.demodd.domain.chat.chatairunmetric.port.repository.ChatAiRunMetricRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ChatAiRunMetricApplicationService implements
        CreateChatAiRunMetricUseCase,
        UpdateChatAiRunMetricUseCase,
        GetChatAiRunMetricUseCase,
        DeleteChatAiRunMetricUseCase {

    private final ChatAiRunMetricRepositoryPort repository;

    public ChatAiRunMetricApplicationService(ChatAiRunMetricRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ChatAiRunMetricResponse execute(String name) {
        ChatAiRunMetric entity = ChatAiRunMetric.create(ChatAiRunMetricName.of(name));
        ChatAiRunMetric saved = repository.save(entity);
        return ChatAiRunMetricResponse.fromDomain(saved);
    }

    @Override
    public ChatAiRunMetricResponse execute(UUID id, String name, String status) {
        ChatAiRunMetricId entityId = ChatAiRunMetricId.of(id);
        ChatAiRunMetric entity = repository.findById(entityId)
                .orElseThrow(() -> new ChatAiRunMetricNotFoundException(entityId));

        entity.update(ChatAiRunMetricName.of(name), ChatAiRunMetricStatus.of(status));
        ChatAiRunMetric updated = repository.save(entity);
        return ChatAiRunMetricResponse.fromDomain(updated);
    }

    @Override
    public ChatAiRunMetricResponse getById(UUID id) {
        ChatAiRunMetricId entityId = ChatAiRunMetricId.of(id);
        return repository.findById(entityId)
                .map(ChatAiRunMetricResponse::fromDomain)
                .orElseThrow(() -> new ChatAiRunMetricNotFoundException(entityId));
    }

    @Override
    public List<ChatAiRunMetricResponse> getAll() {
        return repository.findAll().stream()
                .map(ChatAiRunMetricResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ChatAiRunMetricId entityId = ChatAiRunMetricId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ChatAiRunMetricNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
