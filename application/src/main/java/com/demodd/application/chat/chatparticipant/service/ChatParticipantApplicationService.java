package com.demodd.application.chat.chatparticipant.service;

import com.demodd.application.chat.chatparticipant.dto.ChatParticipantResponse;
import com.demodd.application.chat.chatparticipant.port.in.CreateChatParticipantUseCase;
import com.demodd.application.chat.chatparticipant.port.in.DeleteChatParticipantUseCase;
import com.demodd.application.chat.chatparticipant.port.in.GetChatParticipantUseCase;
import com.demodd.application.chat.chatparticipant.port.in.UpdateChatParticipantUseCase;
import com.demodd.domain.chat.chatparticipant.exception.ChatParticipantNotFoundException;
import com.demodd.domain.chat.chatparticipant.model.aggregate.ChatParticipant;
import com.demodd.domain.chat.chatparticipant.model.valueobject.ChatParticipantId;
import com.demodd.domain.chat.chatparticipant.model.valueobject.ChatParticipantName;
import com.demodd.domain.chat.chatparticipant.model.valueobject.ChatParticipantStatus;
import com.demodd.domain.chat.chatparticipant.port.repository.ChatParticipantRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ChatParticipantApplicationService implements
        CreateChatParticipantUseCase,
        UpdateChatParticipantUseCase,
        GetChatParticipantUseCase,
        DeleteChatParticipantUseCase {

    private final ChatParticipantRepositoryPort repository;

    public ChatParticipantApplicationService(ChatParticipantRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ChatParticipantResponse execute(String name) {
        ChatParticipant entity = ChatParticipant.create(ChatParticipantName.of(name));
        ChatParticipant saved = repository.save(entity);
        return ChatParticipantResponse.fromDomain(saved);
    }

    @Override
    public ChatParticipantResponse execute(UUID id, String name, String status) {
        ChatParticipantId entityId = ChatParticipantId.of(id);
        ChatParticipant entity = repository.findById(entityId)
                .orElseThrow(() -> new ChatParticipantNotFoundException(entityId));

        entity.update(ChatParticipantName.of(name), ChatParticipantStatus.of(status));
        ChatParticipant updated = repository.save(entity);
        return ChatParticipantResponse.fromDomain(updated);
    }

    @Override
    public ChatParticipantResponse getById(UUID id) {
        ChatParticipantId entityId = ChatParticipantId.of(id);
        return repository.findById(entityId)
                .map(ChatParticipantResponse::fromDomain)
                .orElseThrow(() -> new ChatParticipantNotFoundException(entityId));
    }

    @Override
    public List<ChatParticipantResponse> getAll() {
        return repository.findAll().stream()
                .map(ChatParticipantResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ChatParticipantId entityId = ChatParticipantId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ChatParticipantNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
