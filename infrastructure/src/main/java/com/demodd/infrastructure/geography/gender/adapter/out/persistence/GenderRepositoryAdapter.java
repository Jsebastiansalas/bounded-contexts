package com.demodd.infrastructure.geography.gender.adapter.out.persistence;

import com.demodd.domain.geography.gender.model.aggregate.Gender;
import com.demodd.domain.geography.gender.model.valueobject.GenderId;
import com.demodd.domain.geography.gender.model.valueobject.GenderName;
import com.demodd.domain.geography.gender.model.valueobject.GenderStatus;
import com.demodd.domain.geography.gender.port.repository.GenderRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GenderRepositoryAdapter implements GenderRepositoryPort {

    private final GenderSpringDataJpaRepository repository;

    public GenderRepositoryAdapter(GenderSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Gender save(Gender entity) {
        GenderJpaEntity jpaEntity = new GenderJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        GenderJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<Gender> findById(GenderId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<Gender> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(GenderId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(GenderId id) {
        return repository.existsById(id.value());
    }

    private Gender toDomain(GenderJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new Gender(
                GenderId.of(jpa.getId()),
                GenderName.of(entityName),
                GenderStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
