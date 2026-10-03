package com.demodd.infrastructure.clinical.clinicalnote.adapter.out.persistence;

import com.demodd.domain.clinical.clinicalnote.model.aggregate.ClinicalNote;
import com.demodd.domain.clinical.clinicalnote.model.valueobject.ClinicalNoteId;
import com.demodd.domain.clinical.clinicalnote.model.valueobject.ClinicalNoteName;
import com.demodd.domain.clinical.clinicalnote.model.valueobject.ClinicalNoteStatus;
import com.demodd.domain.clinical.clinicalnote.port.repository.ClinicalNoteRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClinicalNoteRepositoryAdapter implements ClinicalNoteRepositoryPort {

    private final ClinicalNoteSpringDataJpaRepository repository;

    public ClinicalNoteRepositoryAdapter(ClinicalNoteSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClinicalNote save(ClinicalNote entity) {
        ClinicalNoteJpaEntity jpaEntity = new ClinicalNoteJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ClinicalNoteJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<ClinicalNote> findById(ClinicalNoteId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<ClinicalNote> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ClinicalNoteId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ClinicalNoteId id) {
        return repository.existsById(id.value());
    }

    private ClinicalNote toDomain(ClinicalNoteJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new ClinicalNote(
                ClinicalNoteId.of(jpa.getId()),
                ClinicalNoteName.of(entityName),
                ClinicalNoteStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
