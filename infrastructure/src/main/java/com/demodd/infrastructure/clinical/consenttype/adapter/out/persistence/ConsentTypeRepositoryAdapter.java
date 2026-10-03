package com.demodd.infrastructure.clinical.consenttype.adapter.out.persistence;

import com.demodd.domain.clinical.consenttype.model.aggregate.ConsentType;
import com.demodd.domain.clinical.consenttype.model.valueobject.ConsentTypeId;
import com.demodd.domain.clinical.consenttype.model.valueobject.ConsentTypeName;
import com.demodd.domain.clinical.consenttype.model.valueobject.ConsentTypeStatus;
import com.demodd.domain.clinical.consenttype.port.repository.ConsentTypeRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ConsentTypeRepositoryAdapter implements ConsentTypeRepositoryPort {

    private final ConsentTypeSpringDataJpaRepository repository;

    public ConsentTypeRepositoryAdapter(ConsentTypeSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ConsentType save(ConsentType entity) {
        ConsentTypeJpaEntity jpaEntity = new ConsentTypeJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ConsentTypeJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<ConsentType> findById(ConsentTypeId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<ConsentType> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ConsentTypeId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ConsentTypeId id) {
        return repository.existsById(id.value());
    }

    private ConsentType toDomain(ConsentTypeJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new ConsentType(
                ConsentTypeId.of(jpa.getId()),
                ConsentTypeName.of(entityName),
                ConsentTypeStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
