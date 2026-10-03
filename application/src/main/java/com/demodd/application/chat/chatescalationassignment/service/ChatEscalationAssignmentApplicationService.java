package com.demodd.application.chat.chatescalationassignment.service;

import com.demodd.application.chat.chatescalationassignment.dto.ChatEscalationAssignmentResponse;
import com.demodd.application.chat.chatescalationassignment.port.in.CreateChatEscalationAssignmentUseCase;
import com.demodd.application.chat.chatescalationassignment.port.in.DeleteChatEscalationAssignmentUseCase;
import com.demodd.application.chat.chatescalationassignment.port.in.GetChatEscalationAssignmentUseCase;
import com.demodd.application.chat.chatescalationassignment.port.in.UpdateChatEscalationAssignmentUseCase;
import com.demodd.domain.chat.chatescalationassignment.exception.ChatEscalationAssignmentNotFoundException;
import com.demodd.domain.chat.chatescalationassignment.model.aggregate.ChatEscalationAssignment;
import com.demodd.domain.chat.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;
import com.demodd.domain.chat.chatescalationassignment.model.valueobject.ChatEscalationAssignmentName;
import com.demodd.domain.chat.chatescalationassignment.model.valueobject.ChatEscalationAssignmentStatus;
import com.demodd.domain.chat.chatescalationassignment.port.repository.ChatEscalationAssignmentRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ChatEscalationAssignmentApplicationService implements
        CreateChatEscalationAssignmentUseCase,
        UpdateChatEscalationAssignmentUseCase,
        GetChatEscalationAssignmentUseCase,
        DeleteChatEscalationAssignmentUseCase {

    private final ChatEscalationAssignmentRepositoryPort repository;

    public ChatEscalationAssignmentApplicationService(ChatEscalationAssignmentRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ChatEscalationAssignmentResponse execute(String name) {
        ChatEscalationAssignment entity = ChatEscalationAssignment.create(ChatEscalationAssignmentName.of(name));
        ChatEscalationAssignment saved = repository.save(entity);
        return ChatEscalationAssignmentResponse.fromDomain(saved);
    }

    @Override
    public ChatEscalationAssignmentResponse execute(UUID id, String name, String status) {
        ChatEscalationAssignmentId entityId = ChatEscalationAssignmentId.of(id);
        ChatEscalationAssignment entity = repository.findById(entityId)
                .orElseThrow(() -> new ChatEscalationAssignmentNotFoundException(entityId));

        entity.update(ChatEscalationAssignmentName.of(name), ChatEscalationAssignmentStatus.of(status));
        ChatEscalationAssignment updated = repository.save(entity);
        return ChatEscalationAssignmentResponse.fromDomain(updated);
    }

    @Override
    public ChatEscalationAssignmentResponse getById(UUID id) {
        ChatEscalationAssignmentId entityId = ChatEscalationAssignmentId.of(id);
        return repository.findById(entityId)
                .map(ChatEscalationAssignmentResponse::fromDomain)
                .orElseThrow(() -> new ChatEscalationAssignmentNotFoundException(entityId));
    }

    @Override
    public List<ChatEscalationAssignmentResponse> getAll() {
        return repository.findAll().stream()
                .map(ChatEscalationAssignmentResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ChatEscalationAssignmentId entityId = ChatEscalationAssignmentId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ChatEscalationAssignmentNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
