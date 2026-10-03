package com.demodd.infrastructure.patient.patient.adapter.out.persistence;

import com.demodd.domain.patient.patient.model.aggregate.Patient;
import com.demodd.domain.patient.patient.model.valueobject.PatientId;
import com.demodd.domain.patient.patient.model.valueobject.PatientName;
import com.demodd.domain.patient.patient.model.valueobject.PatientStatus;
import com.demodd.domain.patient.patient.port.repository.PatientRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PatientRepositoryAdapter implements PatientRepositoryPort {

    private final PatientSpringDataJpaRepository repository;

    public PatientRepositoryAdapter(PatientSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Patient save(Patient entity) {
        PatientJpaEntity jpaEntity = new PatientJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        PatientJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<Patient> findById(PatientId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<Patient> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(PatientId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(PatientId id) {
        return repository.existsById(id.value());
    }

    private Patient toDomain(PatientJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new Patient(
                PatientId.of(jpa.getId()),
                PatientName.of(entityName),
                PatientStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
