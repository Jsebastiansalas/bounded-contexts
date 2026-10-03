package com.demodd.application.chat.chatescalationstatushistory.service;

import com.demodd.application.chat.chatescalationstatushistory.dto.ChatEscalationStatusHistoryResponse;
import com.demodd.application.chat.chatescalationstatushistory.port.in.CreateChatEscalationStatusHistoryUseCase;
import com.demodd.application.chat.chatescalationstatushistory.port.in.DeleteChatEscalationStatusHistoryUseCase;
import com.demodd.application.chat.chatescalationstatushistory.port.in.GetChatEscalationStatusHistoryUseCase;
import com.demodd.application.chat.chatescalationstatushistory.port.in.UpdateChatEscalationStatusHistoryUseCase;
import com.demodd.domain.chat.chatescalationstatushistory.exception.ChatEscalationStatusHistoryNotFoundException;
import com.demodd.domain.chat.chatescalationstatushistory.model.aggregate.ChatEscalationStatusHistory;
import com.demodd.domain.chat.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;
import com.demodd.domain.chat.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryName;
import com.demodd.domain.chat.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryStatus;
import com.demodd.domain.chat.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ChatEscalationStatusHistoryApplicationService implements
        CreateChatEscalationStatusHistoryUseCase,
        UpdateChatEscalationStatusHistoryUseCase,
        GetChatEscalationStatusHistoryUseCase,
        DeleteChatEscalationStatusHistoryUseCase {

    private final ChatEscalationStatusHistoryRepositoryPort repository;

    public ChatEscalationStatusHistoryApplicationService(ChatEscalationStatusHistoryRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ChatEscalationStatusHistoryResponse execute(String name) {
        ChatEscalationStatusHistory entity = ChatEscalationStatusHistory.create(ChatEscalationStatusHistoryName.of(name));
        ChatEscalationStatusHistory saved = repository.save(entity);
        return ChatEscalationStatusHistoryResponse.fromDomain(saved);
    }

    @Override
    public ChatEscalationStatusHistoryResponse execute(UUID id, String name, String status) {
        ChatEscalationStatusHistoryId entityId = ChatEscalationStatusHistoryId.of(id);
        ChatEscalationStatusHistory entity = repository.findById(entityId)
                .orElseThrow(() -> new ChatEscalationStatusHistoryNotFoundException(entityId));

        entity.update(ChatEscalationStatusHistoryName.of(name), ChatEscalationStatusHistoryStatus.of(status));
        ChatEscalationStatusHistory updated = repository.save(entity);
        return ChatEscalationStatusHistoryResponse.fromDomain(updated);
    }

    @Override
    public ChatEscalationStatusHistoryResponse getById(UUID id) {
        ChatEscalationStatusHistoryId entityId = ChatEscalationStatusHistoryId.of(id);
        return repository.findById(entityId)
                .map(ChatEscalationStatusHistoryResponse::fromDomain)
                .orElseThrow(() -> new ChatEscalationStatusHistoryNotFoundException(entityId));
    }

    @Override
    public List<ChatEscalationStatusHistoryResponse> getAll() {
        return repository.findAll().stream()
                .map(ChatEscalationStatusHistoryResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ChatEscalationStatusHistoryId entityId = ChatEscalationStatusHistoryId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ChatEscalationStatusHistoryNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
