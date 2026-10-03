package com.demodd.infrastructure.patient.professionalstudy.adapter.out.persistence;

import com.demodd.domain.patient.professionalstudy.model.aggregate.ProfessionalStudy;
import com.demodd.domain.patient.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.demodd.domain.patient.professionalstudy.model.valueobject.ProfessionalStudyName;
import com.demodd.domain.patient.professionalstudy.model.valueobject.ProfessionalStudyStatus;
import com.demodd.domain.patient.professionalstudy.port.repository.ProfessionalStudyRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProfessionalStudyRepositoryAdapter implements ProfessionalStudyRepositoryPort {

    private final ProfessionalStudySpringDataJpaRepository repository;

    public ProfessionalStudyRepositoryAdapter(ProfessionalStudySpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProfessionalStudy save(ProfessionalStudy entity) {
        ProfessionalStudyJpaEntity jpaEntity = new ProfessionalStudyJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ProfessionalStudyJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<ProfessionalStudy> findById(ProfessionalStudyId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<ProfessionalStudy> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ProfessionalStudyId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ProfessionalStudyId id) {
        return repository.existsById(id.value());
    }

    private ProfessionalStudy toDomain(ProfessionalStudyJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new ProfessionalStudy(
                ProfessionalStudyId.of(jpa.getId()),
                ProfessionalStudyName.of(entityName),
                ProfessionalStudyStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
