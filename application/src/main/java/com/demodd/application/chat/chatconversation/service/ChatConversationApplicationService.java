package com.demodd.application.chat.chatconversation.service;

import com.demodd.application.chat.chatconversation.dto.ChatConversationResponse;
import com.demodd.application.chat.chatconversation.port.in.CreateChatConversationUseCase;
import com.demodd.application.chat.chatconversation.port.in.DeleteChatConversationUseCase;
import com.demodd.application.chat.chatconversation.port.in.GetChatConversationUseCase;
import com.demodd.application.chat.chatconversation.port.in.UpdateChatConversationUseCase;
import com.demodd.domain.chat.chatconversation.exception.ChatConversationNotFoundException;
import com.demodd.domain.chat.chatconversation.model.aggregate.ChatConversation;
import com.demodd.domain.chat.chatconversation.model.valueobject.ChatConversationId;
import com.demodd.domain.chat.chatconversation.model.valueobject.ChatConversationName;
import com.demodd.domain.chat.chatconversation.model.valueobject.ChatConversationStatus;
import com.demodd.domain.chat.chatconversation.port.repository.ChatConversationRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ChatConversationApplicationService implements
        CreateChatConversationUseCase,
        UpdateChatConversationUseCase,
        GetChatConversationUseCase,
        DeleteChatConversationUseCase {

    private final ChatConversationRepositoryPort repository;

    public ChatConversationApplicationService(ChatConversationRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ChatConversationResponse execute(String name) {
        ChatConversation entity = ChatConversation.create(ChatConversationName.of(name));
        ChatConversation saved = repository.save(entity);
        return ChatConversationResponse.fromDomain(saved);
    }

    @Override
    public ChatConversationResponse execute(UUID id, String name, String status) {
        ChatConversationId entityId = ChatConversationId.of(id);
        ChatConversation entity = repository.findById(entityId)
                .orElseThrow(() -> new ChatConversationNotFoundException(entityId));

        entity.update(ChatConversationName.of(name), ChatConversationStatus.of(status));
        ChatConversation updated = repository.save(entity);
        return ChatConversationResponse.fromDomain(updated);
    }

    @Override
    public ChatConversationResponse getById(UUID id) {
        ChatConversationId entityId = ChatConversationId.of(id);
        return repository.findById(entityId)
                .map(ChatConversationResponse::fromDomain)
                .orElseThrow(() -> new ChatConversationNotFoundException(entityId));
    }

    @Override
    public List<ChatConversationResponse> getAll() {
        return repository.findAll().stream()
                .map(ChatConversationResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ChatConversationId entityId = ChatConversationId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ChatConversationNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
