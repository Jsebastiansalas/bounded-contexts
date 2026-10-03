package com.demodd.application.geography.documenttype.service;

import com.demodd.application.geography.documenttype.dto.DocumentTypeResponse;
import com.demodd.application.geography.documenttype.port.in.CreateDocumentTypeUseCase;
import com.demodd.application.geography.documenttype.port.in.DeleteDocumentTypeUseCase;
import com.demodd.application.geography.documenttype.port.in.GetDocumentTypeUseCase;
import com.demodd.application.geography.documenttype.port.in.UpdateDocumentTypeUseCase;
import com.demodd.domain.geography.documenttype.exception.DocumentTypeNotFoundException;
import com.demodd.domain.geography.documenttype.model.aggregate.DocumentType;
import com.demodd.domain.geography.documenttype.model.valueobject.DocumentTypeId;
import com.demodd.domain.geography.documenttype.model.valueobject.DocumentTypeName;
import com.demodd.domain.geography.documenttype.model.valueobject.DocumentTypeStatus;
import com.demodd.domain.geography.documenttype.port.repository.DocumentTypeRepositoryPort;

import java.util.List;
import java.util.UUID;

public class DocumentTypeApplicationService implements
        CreateDocumentTypeUseCase,
        UpdateDocumentTypeUseCase,
        GetDocumentTypeUseCase,
        DeleteDocumentTypeUseCase {

    private final DocumentTypeRepositoryPort repository;

    public DocumentTypeApplicationService(DocumentTypeRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public DocumentTypeResponse execute(String name) {
        DocumentType entity = DocumentType.create(DocumentTypeName.of(name));
        DocumentType saved = repository.save(entity);
        return DocumentTypeResponse.fromDomain(saved);
    }

    @Override
    public DocumentTypeResponse execute(UUID id, String name, String status) {
        DocumentTypeId entityId = DocumentTypeId.of(id);
        DocumentType entity = repository.findById(entityId)
                .orElseThrow(() -> new DocumentTypeNotFoundException(entityId));

        entity.update(DocumentTypeName.of(name), DocumentTypeStatus.of(status));
        DocumentType updated = repository.save(entity);
        return DocumentTypeResponse.fromDomain(updated);
    }

    @Override
    public DocumentTypeResponse getById(UUID id) {
        DocumentTypeId entityId = DocumentTypeId.of(id);
        return repository.findById(entityId)
                .map(DocumentTypeResponse::fromDomain)
                .orElseThrow(() -> new DocumentTypeNotFoundException(entityId));
    }

    @Override
    public List<DocumentTypeResponse> getAll() {
        return repository.findAll().stream()
                .map(DocumentTypeResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        DocumentTypeId entityId = DocumentTypeId.of(id);
        if (!repository.existsById(entityId)) {
            throw new DocumentTypeNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
