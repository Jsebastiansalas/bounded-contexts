package com.demodd.application.chat.chatairunerror.service;

import com.demodd.application.chat.chatairunerror.dto.ChatAiRunErrorResponse;
import com.demodd.application.chat.chatairunerror.port.in.CreateChatAiRunErrorUseCase;
import com.demodd.application.chat.chatairunerror.port.in.DeleteChatAiRunErrorUseCase;
import com.demodd.application.chat.chatairunerror.port.in.GetChatAiRunErrorUseCase;
import com.demodd.application.chat.chatairunerror.port.in.UpdateChatAiRunErrorUseCase;
import com.demodd.domain.chat.chatairunerror.exception.ChatAiRunErrorNotFoundException;
import com.demodd.domain.chat.chatairunerror.model.aggregate.ChatAiRunError;
import com.demodd.domain.chat.chatairunerror.model.valueobject.ChatAiRunErrorId;
import com.demodd.domain.chat.chatairunerror.model.valueobject.ChatAiRunErrorName;
import com.demodd.domain.chat.chatairunerror.model.valueobject.ChatAiRunErrorStatus;
import com.demodd.domain.chat.chatairunerror.port.repository.ChatAiRunErrorRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ChatAiRunErrorApplicationService implements
        CreateChatAiRunErrorUseCase,
        UpdateChatAiRunErrorUseCase,
        GetChatAiRunErrorUseCase,
        DeleteChatAiRunErrorUseCase {

    private final ChatAiRunErrorRepositoryPort repository;

    public ChatAiRunErrorApplicationService(ChatAiRunErrorRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ChatAiRunErrorResponse execute(String name) {
        ChatAiRunError entity = ChatAiRunError.create(ChatAiRunErrorName.of(name));
        ChatAiRunError saved = repository.save(entity);
        return ChatAiRunErrorResponse.fromDomain(saved);
    }

    @Override
    public ChatAiRunErrorResponse execute(UUID id, String name, String status) {
        ChatAiRunErrorId entityId = ChatAiRunErrorId.of(id);
        ChatAiRunError entity = repository.findById(entityId)
                .orElseThrow(() -> new ChatAiRunErrorNotFoundException(entityId));

        entity.update(ChatAiRunErrorName.of(name), ChatAiRunErrorStatus.of(status));
        ChatAiRunError updated = repository.save(entity);
        return ChatAiRunErrorResponse.fromDomain(updated);
    }

    @Override
    public ChatAiRunErrorResponse getById(UUID id) {
        ChatAiRunErrorId entityId = ChatAiRunErrorId.of(id);
        return repository.findById(entityId)
                .map(ChatAiRunErrorResponse::fromDomain)
                .orElseThrow(() -> new ChatAiRunErrorNotFoundException(entityId));
    }

    @Override
    public List<ChatAiRunErrorResponse> getAll() {
        return repository.findAll().stream()
                .map(ChatAiRunErrorResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ChatAiRunErrorId entityId = ChatAiRunErrorId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ChatAiRunErrorNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
