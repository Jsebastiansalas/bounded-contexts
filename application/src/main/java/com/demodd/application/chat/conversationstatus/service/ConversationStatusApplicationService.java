package com.demodd.application.chat.conversationstatus.service;

import com.demodd.application.chat.conversationstatus.dto.ConversationStatusResponse;
import com.demodd.application.chat.conversationstatus.port.in.CreateConversationStatusUseCase;
import com.demodd.application.chat.conversationstatus.port.in.DeleteConversationStatusUseCase;
import com.demodd.application.chat.conversationstatus.port.in.GetConversationStatusUseCase;
import com.demodd.application.chat.conversationstatus.port.in.UpdateConversationStatusUseCase;
import com.demodd.domain.chat.conversationstatus.exception.ConversationStatusNotFoundException;
import com.demodd.domain.chat.conversationstatus.model.aggregate.ConversationStatus;
import com.demodd.domain.chat.conversationstatus.model.valueobject.ConversationStatusId;
import com.demodd.domain.chat.conversationstatus.model.valueobject.ConversationStatusName;
import com.demodd.domain.chat.conversationstatus.model.valueobject.ConversationStatusStatus;
import com.demodd.domain.chat.conversationstatus.port.repository.ConversationStatusRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ConversationStatusApplicationService implements
        CreateConversationStatusUseCase,
        UpdateConversationStatusUseCase,
        GetConversationStatusUseCase,
        DeleteConversationStatusUseCase {

    private final ConversationStatusRepositoryPort repository;

    public ConversationStatusApplicationService(ConversationStatusRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ConversationStatusResponse execute(String name) {
        ConversationStatus entity = ConversationStatus.create(ConversationStatusName.of(name));
        ConversationStatus saved = repository.save(entity);
        return ConversationStatusResponse.fromDomain(saved);
    }

    @Override
    public ConversationStatusResponse execute(UUID id, String name, String status) {
        ConversationStatusId entityId = ConversationStatusId.of(id);
        ConversationStatus entity = repository.findById(entityId)
                .orElseThrow(() -> new ConversationStatusNotFoundException(entityId));

        entity.update(ConversationStatusName.of(name), ConversationStatusStatus.of(status));
        ConversationStatus updated = repository.save(entity);
        return ConversationStatusResponse.fromDomain(updated);
    }

    @Override
    public ConversationStatusResponse getById(UUID id) {
        ConversationStatusId entityId = ConversationStatusId.of(id);
        return repository.findById(entityId)
                .map(ConversationStatusResponse::fromDomain)
                .orElseThrow(() -> new ConversationStatusNotFoundException(entityId));
    }

    @Override
    public List<ConversationStatusResponse> getAll() {
        return repository.findAll().stream()
                .map(ConversationStatusResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ConversationStatusId entityId = ConversationStatusId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ConversationStatusNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
