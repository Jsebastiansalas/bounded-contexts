package com.demodd.infrastructure.patient.patientallergy.adapter.out.persistence;

import com.demodd.domain.patient.patientallergy.model.aggregate.PatientAllergy;
import com.demodd.domain.patient.patientallergy.model.valueobject.PatientAllergyId;
import com.demodd.domain.patient.patientallergy.model.valueobject.PatientAllergyName;
import com.demodd.domain.patient.patientallergy.model.valueobject.PatientAllergyStatus;
import com.demodd.domain.patient.patientallergy.port.repository.PatientAllergyRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PatientAllergyRepositoryAdapter implements PatientAllergyRepositoryPort {

    private final PatientAllergySpringDataJpaRepository repository;

    public PatientAllergyRepositoryAdapter(PatientAllergySpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public PatientAllergy save(PatientAllergy entity) {
        PatientAllergyJpaEntity jpaEntity = new PatientAllergyJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        PatientAllergyJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<PatientAllergy> findById(PatientAllergyId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<PatientAllergy> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(PatientAllergyId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(PatientAllergyId id) {
        return repository.existsById(id.value());
    }

    private PatientAllergy toDomain(PatientAllergyJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new PatientAllergy(
                PatientAllergyId.of(jpa.getId()),
                PatientAllergyName.of(entityName),
                PatientAllergyStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
