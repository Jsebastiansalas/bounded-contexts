package com.demodd.infrastructure.geography.relationshiptype.adapter.out.persistence;

import com.demodd.domain.geography.relationshiptype.model.aggregate.RelationshipType;
import com.demodd.domain.geography.relationshiptype.model.valueobject.RelationshipTypeId;
import com.demodd.domain.geography.relationshiptype.model.valueobject.RelationshipTypeName;
import com.demodd.domain.geography.relationshiptype.model.valueobject.RelationshipTypeStatus;
import com.demodd.domain.geography.relationshiptype.port.repository.RelationshipTypeRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RelationshipTypeRepositoryAdapter implements RelationshipTypeRepositoryPort {

    private final RelationshipTypeSpringDataJpaRepository repository;

    public RelationshipTypeRepositoryAdapter(RelationshipTypeSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public RelationshipType save(RelationshipType entity) {
        RelationshipTypeJpaEntity jpaEntity = new RelationshipTypeJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        RelationshipTypeJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<RelationshipType> findById(RelationshipTypeId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<RelationshipType> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(RelationshipTypeId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(RelationshipTypeId id) {
        return repository.existsById(id.value());
    }

    private RelationshipType toDomain(RelationshipTypeJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new RelationshipType(
                RelationshipTypeId.of(jpa.getId()),
                RelationshipTypeName.of(entityName),
                RelationshipTypeStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
