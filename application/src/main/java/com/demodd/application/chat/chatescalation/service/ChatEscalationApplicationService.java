package com.demodd.application.chat.chatescalation.service;

import com.demodd.application.chat.chatescalation.dto.ChatEscalationResponse;
import com.demodd.application.chat.chatescalation.port.in.CreateChatEscalationUseCase;
import com.demodd.application.chat.chatescalation.port.in.DeleteChatEscalationUseCase;
import com.demodd.application.chat.chatescalation.port.in.GetChatEscalationUseCase;
import com.demodd.application.chat.chatescalation.port.in.UpdateChatEscalationUseCase;
import com.demodd.domain.chat.chatescalation.exception.ChatEscalationNotFoundException;
import com.demodd.domain.chat.chatescalation.model.aggregate.ChatEscalation;
import com.demodd.domain.chat.chatescalation.model.valueobject.ChatEscalationId;
import com.demodd.domain.chat.chatescalation.model.valueobject.ChatEscalationName;
import com.demodd.domain.chat.chatescalation.model.valueobject.ChatEscalationStatus;
import com.demodd.domain.chat.chatescalation.port.repository.ChatEscalationRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ChatEscalationApplicationService implements
        CreateChatEscalationUseCase,
        UpdateChatEscalationUseCase,
        GetChatEscalationUseCase,
        DeleteChatEscalationUseCase {

    private final ChatEscalationRepositoryPort repository;

    public ChatEscalationApplicationService(ChatEscalationRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ChatEscalationResponse execute(String name) {
        ChatEscalation entity = ChatEscalation.create(ChatEscalationName.of(name));
        ChatEscalation saved = repository.save(entity);
        return ChatEscalationResponse.fromDomain(saved);
    }

    @Override
    public ChatEscalationResponse execute(UUID id, String name, String status) {
        ChatEscalationId entityId = ChatEscalationId.of(id);
        ChatEscalation entity = repository.findById(entityId)
                .orElseThrow(() -> new ChatEscalationNotFoundException(entityId));

        entity.update(ChatEscalationName.of(name), ChatEscalationStatus.of(status));
        ChatEscalation updated = repository.save(entity);
        return ChatEscalationResponse.fromDomain(updated);
    }

    @Override
    public ChatEscalationResponse getById(UUID id) {
        ChatEscalationId entityId = ChatEscalationId.of(id);
        return repository.findById(entityId)
                .map(ChatEscalationResponse::fromDomain)
                .orElseThrow(() -> new ChatEscalationNotFoundException(entityId));
    }

    @Override
    public List<ChatEscalationResponse> getAll() {
        return repository.findAll().stream()
                .map(ChatEscalationResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ChatEscalationId entityId = ChatEscalationId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ChatEscalationNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
