package com.demodd.infrastructure.geography.documenttype.adapter.out.persistence;

import com.demodd.domain.geography.documenttype.model.aggregate.DocumentType;
import com.demodd.domain.geography.documenttype.model.valueobject.DocumentTypeId;
import com.demodd.domain.geography.documenttype.model.valueobject.DocumentTypeName;
import com.demodd.domain.geography.documenttype.model.valueobject.DocumentTypeStatus;
import com.demodd.domain.geography.documenttype.port.repository.DocumentTypeRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DocumentTypeRepositoryAdapter implements DocumentTypeRepositoryPort {

    private final DocumentTypeSpringDataJpaRepository repository;

    public DocumentTypeRepositoryAdapter(DocumentTypeSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public DocumentType save(DocumentType entity) {
        DocumentTypeJpaEntity jpaEntity = new DocumentTypeJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        DocumentTypeJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<DocumentType> findById(DocumentTypeId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<DocumentType> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(DocumentTypeId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(DocumentTypeId id) {
        return repository.existsById(id.value());
    }

    private DocumentType toDomain(DocumentTypeJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new DocumentType(
                DocumentTypeId.of(jpa.getId()),
                DocumentTypeName.of(entityName),
                DocumentTypeStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
