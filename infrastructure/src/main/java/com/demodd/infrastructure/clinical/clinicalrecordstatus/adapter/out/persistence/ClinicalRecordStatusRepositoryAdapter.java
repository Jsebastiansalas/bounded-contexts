package com.demodd.infrastructure.clinical.clinicalrecordstatus.adapter.out.persistence;

import com.demodd.domain.clinical.clinicalrecordstatus.model.aggregate.ClinicalRecordStatus;
import com.demodd.domain.clinical.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;
import com.demodd.domain.clinical.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusName;
import com.demodd.domain.clinical.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusStatus;
import com.demodd.domain.clinical.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClinicalRecordStatusRepositoryAdapter implements ClinicalRecordStatusRepositoryPort {

    private final ClinicalRecordStatusSpringDataJpaRepository repository;

    public ClinicalRecordStatusRepositoryAdapter(ClinicalRecordStatusSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClinicalRecordStatus save(ClinicalRecordStatus entity) {
        ClinicalRecordStatusJpaEntity jpaEntity = new ClinicalRecordStatusJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ClinicalRecordStatusJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<ClinicalRecordStatus> findById(ClinicalRecordStatusId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<ClinicalRecordStatus> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ClinicalRecordStatusId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ClinicalRecordStatusId id) {
        return repository.existsById(id.value());
    }

    private ClinicalRecordStatus toDomain(ClinicalRecordStatusJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new ClinicalRecordStatus(
                ClinicalRecordStatusId.of(jpa.getId()),
                ClinicalRecordStatusName.of(entityName),
                ClinicalRecordStatusStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
