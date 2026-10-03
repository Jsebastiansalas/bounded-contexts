package com.demodd.domain.geography.relationshiptype.port.repository;

import com.demodd.domain.geography.relationshiptype.model.aggregate.RelationshipType;
import com.demodd.domain.geography.relationshiptype.model.valueobject.RelationshipTypeId;

import java.util.List;
import java.util.Optional;

public interface RelationshipTypeRepositoryPort {

    RelationshipType save(RelationshipType entity);

    Optional<RelationshipType> findById(RelationshipTypeId id);

    List<RelationshipType> findAll();

    void deleteById(RelationshipTypeId id);

    boolean existsById(RelationshipTypeId id);
}
