package com.demodd.infrastructure.chat.sendertype.adapter.out.persistence;

import com.demodd.domain.chat.sendertype.model.aggregate.SenderType;
import com.demodd.domain.chat.sendertype.model.valueobject.SenderTypeId;
import com.demodd.domain.chat.sendertype.model.valueobject.SenderTypeName;
import com.demodd.domain.chat.sendertype.model.valueobject.SenderTypeStatus;
import com.demodd.domain.chat.sendertype.port.repository.SenderTypeRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SenderTypeRepositoryAdapter implements SenderTypeRepositoryPort {

    private final SenderTypeSpringDataJpaRepository repository;

    public SenderTypeRepositoryAdapter(SenderTypeSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public SenderType save(SenderType entity) {
        SenderTypeJpaEntity jpaEntity = new SenderTypeJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        SenderTypeJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<SenderType> findById(SenderTypeId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<SenderType> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(SenderTypeId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(SenderTypeId id) {
        return repository.existsById(id.value());
    }

    private SenderType toDomain(SenderTypeJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new SenderType(
                SenderTypeId.of(jpa.getId()),
                SenderTypeName.of(entityName),
                SenderTypeStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
