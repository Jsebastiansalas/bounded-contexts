package com.demodd.application.chat.providermodelai.service;

import com.demodd.application.chat.providermodelai.dto.ProviderModelAiResponse;
import com.demodd.application.chat.providermodelai.port.in.CreateProviderModelAiUseCase;
import com.demodd.application.chat.providermodelai.port.in.DeleteProviderModelAiUseCase;
import com.demodd.application.chat.providermodelai.port.in.GetProviderModelAiUseCase;
import com.demodd.application.chat.providermodelai.port.in.UpdateProviderModelAiUseCase;
import com.demodd.domain.chat.providermodelai.exception.ProviderModelAiNotFoundException;
import com.demodd.domain.chat.providermodelai.model.aggregate.ProviderModelAi;
import com.demodd.domain.chat.providermodelai.model.valueobject.ProviderModelAiId;
import com.demodd.domain.chat.providermodelai.model.valueobject.ProviderModelAiName;
import com.demodd.domain.chat.providermodelai.model.valueobject.ProviderModelAiStatus;
import com.demodd.domain.chat.providermodelai.port.repository.ProviderModelAiRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ProviderModelAiApplicationService implements
        CreateProviderModelAiUseCase,
        UpdateProviderModelAiUseCase,
        GetProviderModelAiUseCase,
        DeleteProviderModelAiUseCase {

    private final ProviderModelAiRepositoryPort repository;

    public ProviderModelAiApplicationService(ProviderModelAiRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ProviderModelAiResponse execute(String name) {
        ProviderModelAi entity = ProviderModelAi.create(ProviderModelAiName.of(name));
        ProviderModelAi saved = repository.save(entity);
        return ProviderModelAiResponse.fromDomain(saved);
    }

    @Override
    public ProviderModelAiResponse execute(UUID id, String name, String status) {
        ProviderModelAiId entityId = ProviderModelAiId.of(id);
        ProviderModelAi entity = repository.findById(entityId)
                .orElseThrow(() -> new ProviderModelAiNotFoundException(entityId));

        entity.update(ProviderModelAiName.of(name), ProviderModelAiStatus.of(status));
        ProviderModelAi updated = repository.save(entity);
        return ProviderModelAiResponse.fromDomain(updated);
    }

    @Override
    public ProviderModelAiResponse getById(UUID id) {
        ProviderModelAiId entityId = ProviderModelAiId.of(id);
        return repository.findById(entityId)
                .map(ProviderModelAiResponse::fromDomain)
                .orElseThrow(() -> new ProviderModelAiNotFoundException(entityId));
    }

    @Override
    public List<ProviderModelAiResponse> getAll() {
        return repository.findAll().stream()
                .map(ProviderModelAiResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ProviderModelAiId entityId = ProviderModelAiId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ProviderModelAiNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
