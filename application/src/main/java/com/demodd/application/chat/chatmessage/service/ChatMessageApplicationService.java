package com.demodd.application.chat.chatmessage.service;

import com.demodd.application.chat.chatmessage.dto.ChatMessageResponse;
import com.demodd.application.chat.chatmessage.port.in.CreateChatMessageUseCase;
import com.demodd.application.chat.chatmessage.port.in.DeleteChatMessageUseCase;
import com.demodd.application.chat.chatmessage.port.in.GetChatMessageUseCase;
import com.demodd.application.chat.chatmessage.port.in.UpdateChatMessageUseCase;
import com.demodd.domain.chat.chatmessage.exception.ChatMessageNotFoundException;
import com.demodd.domain.chat.chatmessage.model.aggregate.ChatMessage;
import com.demodd.domain.chat.chatmessage.model.valueobject.ChatMessageId;
import com.demodd.domain.chat.chatmessage.model.valueobject.ChatMessageName;
import com.demodd.domain.chat.chatmessage.model.valueobject.ChatMessageStatus;
import com.demodd.domain.chat.chatmessage.port.repository.ChatMessageRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ChatMessageApplicationService implements
        CreateChatMessageUseCase,
        UpdateChatMessageUseCase,
        GetChatMessageUseCase,
        DeleteChatMessageUseCase {

    private final ChatMessageRepositoryPort repository;

    public ChatMessageApplicationService(ChatMessageRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ChatMessageResponse execute(String name) {
        ChatMessage entity = ChatMessage.create(ChatMessageName.of(name));
        ChatMessage saved = repository.save(entity);
        return ChatMessageResponse.fromDomain(saved);
    }

    @Override
    public ChatMessageResponse execute(UUID id, String name, String status) {
        ChatMessageId entityId = ChatMessageId.of(id);
        ChatMessage entity = repository.findById(entityId)
                .orElseThrow(() -> new ChatMessageNotFoundException(entityId));

        entity.update(ChatMessageName.of(name), ChatMessageStatus.of(status));
        ChatMessage updated = repository.save(entity);
        return ChatMessageResponse.fromDomain(updated);
    }

    @Override
    public ChatMessageResponse getById(UUID id) {
        ChatMessageId entityId = ChatMessageId.of(id);
        return repository.findById(entityId)
                .map(ChatMessageResponse::fromDomain)
                .orElseThrow(() -> new ChatMessageNotFoundException(entityId));
    }

    @Override
    public List<ChatMessageResponse> getAll() {
        return repository.findAll().stream()
                .map(ChatMessageResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ChatMessageId entityId = ChatMessageId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ChatMessageNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
