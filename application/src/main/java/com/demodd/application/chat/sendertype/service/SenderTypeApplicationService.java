package com.demodd.application.chat.sendertype.service;

import com.demodd.application.chat.sendertype.dto.SenderTypeResponse;
import com.demodd.application.chat.sendertype.port.in.CreateSenderTypeUseCase;
import com.demodd.application.chat.sendertype.port.in.DeleteSenderTypeUseCase;
import com.demodd.application.chat.sendertype.port.in.GetSenderTypeUseCase;
import com.demodd.application.chat.sendertype.port.in.UpdateSenderTypeUseCase;
import com.demodd.domain.chat.sendertype.exception.SenderTypeNotFoundException;
import com.demodd.domain.chat.sendertype.model.aggregate.SenderType;
import com.demodd.domain.chat.sendertype.model.valueobject.SenderTypeId;
import com.demodd.domain.chat.sendertype.model.valueobject.SenderTypeName;
import com.demodd.domain.chat.sendertype.model.valueobject.SenderTypeStatus;
import com.demodd.domain.chat.sendertype.port.repository.SenderTypeRepositoryPort;

import java.util.List;
import java.util.UUID;

public class SenderTypeApplicationService implements
        CreateSenderTypeUseCase,
        UpdateSenderTypeUseCase,
        GetSenderTypeUseCase,
        DeleteSenderTypeUseCase {

    private final SenderTypeRepositoryPort repository;

    public SenderTypeApplicationService(SenderTypeRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public SenderTypeResponse execute(String name) {
        SenderType entity = SenderType.create(SenderTypeName.of(name));
        SenderType saved = repository.save(entity);
        return SenderTypeResponse.fromDomain(saved);
    }

    @Override
    public SenderTypeResponse execute(UUID id, String name, String status) {
        SenderTypeId entityId = SenderTypeId.of(id);
        SenderType entity = repository.findById(entityId)
                .orElseThrow(() -> new SenderTypeNotFoundException(entityId));

        entity.update(SenderTypeName.of(name), SenderTypeStatus.of(status));
        SenderType updated = repository.save(entity);
        return SenderTypeResponse.fromDomain(updated);
    }

    @Override
    public SenderTypeResponse getById(UUID id) {
        SenderTypeId entityId = SenderTypeId.of(id);
        return repository.findById(entityId)
                .map(SenderTypeResponse::fromDomain)
                .orElseThrow(() -> new SenderTypeNotFoundException(entityId));
    }

    @Override
    public List<SenderTypeResponse> getAll() {
        return repository.findAll().stream()
                .map(SenderTypeResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        SenderTypeId entityId = SenderTypeId.of(id);
        if (!repository.existsById(entityId)) {
            throw new SenderTypeNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
