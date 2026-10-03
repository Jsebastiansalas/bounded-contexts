package com.demodd.application.chat.chatairun.service;

import com.demodd.application.chat.chatairun.dto.ChatAiRunResponse;
import com.demodd.application.chat.chatairun.port.in.CreateChatAiRunUseCase;
import com.demodd.application.chat.chatairun.port.in.DeleteChatAiRunUseCase;
import com.demodd.application.chat.chatairun.port.in.GetChatAiRunUseCase;
import com.demodd.application.chat.chatairun.port.in.UpdateChatAiRunUseCase;
import com.demodd.domain.chat.chatairun.exception.ChatAiRunNotFoundException;
import com.demodd.domain.chat.chatairun.model.aggregate.ChatAiRun;
import com.demodd.domain.chat.chatairun.model.valueobject.ChatAiRunId;
import com.demodd.domain.chat.chatairun.model.valueobject.ChatAiRunName;
import com.demodd.domain.chat.chatairun.model.valueobject.ChatAiRunStatus;
import com.demodd.domain.chat.chatairun.port.repository.ChatAiRunRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ChatAiRunApplicationService implements
        CreateChatAiRunUseCase,
        UpdateChatAiRunUseCase,
        GetChatAiRunUseCase,
        DeleteChatAiRunUseCase {

    private final ChatAiRunRepositoryPort repository;

    public ChatAiRunApplicationService(ChatAiRunRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ChatAiRunResponse execute(String name) {
        ChatAiRun entity = ChatAiRun.create(ChatAiRunName.of(name));
        ChatAiRun saved = repository.save(entity);
        return ChatAiRunResponse.fromDomain(saved);
    }

    @Override
    public ChatAiRunResponse execute(UUID id, String name, String status) {
        ChatAiRunId entityId = ChatAiRunId.of(id);
        ChatAiRun entity = repository.findById(entityId)
                .orElseThrow(() -> new ChatAiRunNotFoundException(entityId));

        entity.update(ChatAiRunName.of(name), ChatAiRunStatus.of(status));
        ChatAiRun updated = repository.save(entity);
        return ChatAiRunResponse.fromDomain(updated);
    }

    @Override
    public ChatAiRunResponse getById(UUID id) {
        ChatAiRunId entityId = ChatAiRunId.of(id);
        return repository.findById(entityId)
                .map(ChatAiRunResponse::fromDomain)
                .orElseThrow(() -> new ChatAiRunNotFoundException(entityId));
    }

    @Override
    public List<ChatAiRunResponse> getAll() {
        return repository.findAll().stream()
                .map(ChatAiRunResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ChatAiRunId entityId = ChatAiRunId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ChatAiRunNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
