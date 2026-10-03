package com.demodd.application.chat.messagetype.service;

import com.demodd.application.chat.messagetype.dto.MessageTypeResponse;
import com.demodd.application.chat.messagetype.port.in.CreateMessageTypeUseCase;
import com.demodd.application.chat.messagetype.port.in.DeleteMessageTypeUseCase;
import com.demodd.application.chat.messagetype.port.in.GetMessageTypeUseCase;
import com.demodd.application.chat.messagetype.port.in.UpdateMessageTypeUseCase;
import com.demodd.domain.chat.messagetype.exception.MessageTypeNotFoundException;
import com.demodd.domain.chat.messagetype.model.aggregate.MessageType;
import com.demodd.domain.chat.messagetype.model.valueobject.MessageTypeId;
import com.demodd.domain.chat.messagetype.model.valueobject.MessageTypeName;
import com.demodd.domain.chat.messagetype.model.valueobject.MessageTypeStatus;
import com.demodd.domain.chat.messagetype.port.repository.MessageTypeRepositoryPort;

import java.util.List;
import java.util.UUID;

public class MessageTypeApplicationService implements
        CreateMessageTypeUseCase,
        UpdateMessageTypeUseCase,
        GetMessageTypeUseCase,
        DeleteMessageTypeUseCase {

    private final MessageTypeRepositoryPort repository;

    public MessageTypeApplicationService(MessageTypeRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public MessageTypeResponse execute(String name) {
        MessageType entity = MessageType.create(MessageTypeName.of(name));
        MessageType saved = repository.save(entity);
        return MessageTypeResponse.fromDomain(saved);
    }

    @Override
    public MessageTypeResponse execute(UUID id, String name, String status) {
        MessageTypeId entityId = MessageTypeId.of(id);
        MessageType entity = repository.findById(entityId)
                .orElseThrow(() -> new MessageTypeNotFoundException(entityId));

        entity.update(MessageTypeName.of(name), MessageTypeStatus.of(status));
        MessageType updated = repository.save(entity);
        return MessageTypeResponse.fromDomain(updated);
    }

    @Override
    public MessageTypeResponse getById(UUID id) {
        MessageTypeId entityId = MessageTypeId.of(id);
        return repository.findById(entityId)
                .map(MessageTypeResponse::fromDomain)
                .orElseThrow(() -> new MessageTypeNotFoundException(entityId));
    }

    @Override
    public List<MessageTypeResponse> getAll() {
        return repository.findAll().stream()
                .map(MessageTypeResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        MessageTypeId entityId = MessageTypeId.of(id);
        if (!repository.existsById(entityId)) {
            throw new MessageTypeNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
