package com.demodd.infrastructure.clinical.mentalstatusexam.adapter.out.persistence;

import com.demodd.domain.clinical.mentalstatusexam.model.aggregate.MentalStatusExam;
import com.demodd.domain.clinical.mentalstatusexam.model.valueobject.MentalStatusExamId;
import com.demodd.domain.clinical.mentalstatusexam.model.valueobject.MentalStatusExamName;
import com.demodd.domain.clinical.mentalstatusexam.model.valueobject.MentalStatusExamStatus;
import com.demodd.domain.clinical.mentalstatusexam.port.repository.MentalStatusExamRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MentalStatusExamRepositoryAdapter implements MentalStatusExamRepositoryPort {

    private final MentalStatusExamSpringDataJpaRepository repository;

    public MentalStatusExamRepositoryAdapter(MentalStatusExamSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public MentalStatusExam save(MentalStatusExam entity) {
        MentalStatusExamJpaEntity jpaEntity = new MentalStatusExamJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        MentalStatusExamJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<MentalStatusExam> findById(MentalStatusExamId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<MentalStatusExam> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(MentalStatusExamId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(MentalStatusExamId id) {
        return repository.existsById(id.value());
    }

    private MentalStatusExam toDomain(MentalStatusExamJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new MentalStatusExam(
                MentalStatusExamId.of(jpa.getId()),
                MentalStatusExamName.of(entityName),
                MentalStatusExamStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
