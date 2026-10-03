package com.demodd.infrastructure.clinical.clinicalrecord.adapter.out.persistence;

import com.demodd.domain.clinical.clinicalrecord.model.aggregate.ClinicalRecord;
import com.demodd.domain.clinical.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.demodd.domain.clinical.clinicalrecord.model.valueobject.ClinicalRecordName;
import com.demodd.domain.clinical.clinicalrecord.model.valueobject.ClinicalRecordStatus;
import com.demodd.domain.clinical.clinicalrecord.port.repository.ClinicalRecordRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClinicalRecordRepositoryAdapter implements ClinicalRecordRepositoryPort {

    private final ClinicalRecordSpringDataJpaRepository repository;

    public ClinicalRecordRepositoryAdapter(ClinicalRecordSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClinicalRecord save(ClinicalRecord entity) {
        ClinicalRecordJpaEntity jpaEntity = new ClinicalRecordJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ClinicalRecordJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<ClinicalRecord> findById(ClinicalRecordId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<ClinicalRecord> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ClinicalRecordId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ClinicalRecordId id) {
        return repository.existsById(id.value());
    }

    private ClinicalRecord toDomain(ClinicalRecordJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new ClinicalRecord(
                ClinicalRecordId.of(jpa.getId()),
                ClinicalRecordName.of(entityName),
                ClinicalRecordStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
