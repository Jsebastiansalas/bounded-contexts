package com.demodd.infrastructure.geography.study.adapter.out.persistence;

import com.demodd.domain.geography.study.model.aggregate.Study;
import com.demodd.domain.geography.study.model.valueobject.StudyId;
import com.demodd.domain.geography.study.model.valueobject.StudyName;
import com.demodd.domain.geography.study.model.valueobject.StudyStatus;
import com.demodd.domain.geography.study.port.repository.StudyRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudyRepositoryAdapter implements StudyRepositoryPort {

    private final StudySpringDataJpaRepository repository;

    public StudyRepositoryAdapter(StudySpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Study save(Study entity) {
        StudyJpaEntity jpaEntity = new StudyJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        StudyJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<Study> findById(StudyId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<Study> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(StudyId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(StudyId id) {
        return repository.existsById(id.value());
    }

    private Study toDomain(StudyJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new Study(
                StudyId.of(jpa.getId()),
                StudyName.of(entityName),
                StudyStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
