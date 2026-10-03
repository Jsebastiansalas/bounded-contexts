package com.demodd.infrastructure.chat.priority.adapter.out.persistence;

import com.demodd.domain.chat.priority.model.aggregate.Priority;
import com.demodd.domain.chat.priority.model.valueobject.PriorityId;
import com.demodd.domain.chat.priority.model.valueobject.PriorityName;
import com.demodd.domain.chat.priority.model.valueobject.PriorityStatus;
import com.demodd.domain.chat.priority.port.repository.PriorityRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PriorityRepositoryAdapter implements PriorityRepositoryPort {

    private final PrioritySpringDataJpaRepository repository;

    public PriorityRepositoryAdapter(PrioritySpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Priority save(Priority entity) {
        PriorityJpaEntity jpaEntity = new PriorityJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        PriorityJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<Priority> findById(PriorityId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<Priority> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(PriorityId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(PriorityId id) {
        return repository.existsById(id.value());
    }

    private Priority toDomain(PriorityJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new Priority(
                PriorityId.of(jpa.getId()),
                PriorityName.of(entityName),
                PriorityStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
