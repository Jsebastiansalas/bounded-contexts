package com.demodd.application.chat.chatconversationaisetting.service;

import com.demodd.application.chat.chatconversationaisetting.dto.ChatConversationAiSettingResponse;
import com.demodd.application.chat.chatconversationaisetting.port.in.CreateChatConversationAiSettingUseCase;
import com.demodd.application.chat.chatconversationaisetting.port.in.DeleteChatConversationAiSettingUseCase;
import com.demodd.application.chat.chatconversationaisetting.port.in.GetChatConversationAiSettingUseCase;
import com.demodd.application.chat.chatconversationaisetting.port.in.UpdateChatConversationAiSettingUseCase;
import com.demodd.domain.chat.chatconversationaisetting.exception.ChatConversationAiSettingNotFoundException;
import com.demodd.domain.chat.chatconversationaisetting.model.aggregate.ChatConversationAiSetting;
import com.demodd.domain.chat.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;
import com.demodd.domain.chat.chatconversationaisetting.model.valueobject.ChatConversationAiSettingName;
import com.demodd.domain.chat.chatconversationaisetting.model.valueobject.ChatConversationAiSettingStatus;
import com.demodd.domain.chat.chatconversationaisetting.port.repository.ChatConversationAiSettingRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ChatConversationAiSettingApplicationService implements
        CreateChatConversationAiSettingUseCase,
        UpdateChatConversationAiSettingUseCase,
        GetChatConversationAiSettingUseCase,
        DeleteChatConversationAiSettingUseCase {

    private final ChatConversationAiSettingRepositoryPort repository;

    public ChatConversationAiSettingApplicationService(ChatConversationAiSettingRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ChatConversationAiSettingResponse execute(String name) {
        ChatConversationAiSetting entity = ChatConversationAiSetting.create(ChatConversationAiSettingName.of(name));
        ChatConversationAiSetting saved = repository.save(entity);
        return ChatConversationAiSettingResponse.fromDomain(saved);
    }

    @Override
    public ChatConversationAiSettingResponse execute(UUID id, String name, String status) {
        ChatConversationAiSettingId entityId = ChatConversationAiSettingId.of(id);
        ChatConversationAiSetting entity = repository.findById(entityId)
                .orElseThrow(() -> new ChatConversationAiSettingNotFoundException(entityId));

        entity.update(ChatConversationAiSettingName.of(name), ChatConversationAiSettingStatus.of(status));
        ChatConversationAiSetting updated = repository.save(entity);
        return ChatConversationAiSettingResponse.fromDomain(updated);
    }

    @Override
    public ChatConversationAiSettingResponse getById(UUID id) {
        ChatConversationAiSettingId entityId = ChatConversationAiSettingId.of(id);
        return repository.findById(entityId)
                .map(ChatConversationAiSettingResponse::fromDomain)
                .orElseThrow(() -> new ChatConversationAiSettingNotFoundException(entityId));
    }

    @Override
    public List<ChatConversationAiSettingResponse> getAll() {
        return repository.findAll().stream()
                .map(ChatConversationAiSettingResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ChatConversationAiSettingId entityId = ChatConversationAiSettingId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ChatConversationAiSettingNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
