package com.demodd.application.geography.relationshiptype.service;

import com.demodd.application.geography.relationshiptype.dto.RelationshipTypeResponse;
import com.demodd.application.geography.relationshiptype.port.in.CreateRelationshipTypeUseCase;
import com.demodd.application.geography.relationshiptype.port.in.DeleteRelationshipTypeUseCase;
import com.demodd.application.geography.relationshiptype.port.in.GetRelationshipTypeUseCase;
import com.demodd.application.geography.relationshiptype.port.in.UpdateRelationshipTypeUseCase;
import com.demodd.domain.geography.relationshiptype.exception.RelationshipTypeNotFoundException;
import com.demodd.domain.geography.relationshiptype.model.aggregate.RelationshipType;
import com.demodd.domain.geography.relationshiptype.model.valueobject.RelationshipTypeId;
import com.demodd.domain.geography.relationshiptype.model.valueobject.RelationshipTypeName;
import com.demodd.domain.geography.relationshiptype.model.valueobject.RelationshipTypeStatus;
import com.demodd.domain.geography.relationshiptype.port.repository.RelationshipTypeRepositoryPort;

import java.util.List;
import java.util.UUID;

public class RelationshipTypeApplicationService implements
        CreateRelationshipTypeUseCase,
        UpdateRelationshipTypeUseCase,
        GetRelationshipTypeUseCase,
        DeleteRelationshipTypeUseCase {

    private final RelationshipTypeRepositoryPort repository;

    public RelationshipTypeApplicationService(RelationshipTypeRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public RelationshipTypeResponse execute(String name) {
        RelationshipType entity = RelationshipType.create(RelationshipTypeName.of(name));
        RelationshipType saved = repository.save(entity);
        return RelationshipTypeResponse.fromDomain(saved);
    }

    @Override
    public RelationshipTypeResponse execute(UUID id, String name, String status) {
        RelationshipTypeId entityId = RelationshipTypeId.of(id);
        RelationshipType entity = repository.findById(entityId)
                .orElseThrow(() -> new RelationshipTypeNotFoundException(entityId));

        entity.update(RelationshipTypeName.of(name), RelationshipTypeStatus.of(status));
        RelationshipType updated = repository.save(entity);
        return RelationshipTypeResponse.fromDomain(updated);
    }

    @Override
    public RelationshipTypeResponse getById(UUID id) {
        RelationshipTypeId entityId = RelationshipTypeId.of(id);
        return repository.findById(entityId)
                .map(RelationshipTypeResponse::fromDomain)
                .orElseThrow(() -> new RelationshipTypeNotFoundException(entityId));
    }

    @Override
    public List<RelationshipTypeResponse> getAll() {
        return repository.findAll().stream()
                .map(RelationshipTypeResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        RelationshipTypeId entityId = RelationshipTypeId.of(id);
        if (!repository.existsById(entityId)) {
            throw new RelationshipTypeNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
