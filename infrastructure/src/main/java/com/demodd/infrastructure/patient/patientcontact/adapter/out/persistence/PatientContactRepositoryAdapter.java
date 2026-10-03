package com.demodd.infrastructure.patient.patientcontact.adapter.out.persistence;

import com.demodd.domain.patient.patientcontact.model.aggregate.PatientContact;
import com.demodd.domain.patient.patientcontact.model.valueobject.PatientContactId;
import com.demodd.domain.patient.patientcontact.model.valueobject.PatientContactName;
import com.demodd.domain.patient.patientcontact.model.valueobject.PatientContactStatus;
import com.demodd.domain.patient.patientcontact.port.repository.PatientContactRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PatientContactRepositoryAdapter implements PatientContactRepositoryPort {

    private final PatientContactSpringDataJpaRepository repository;

    public PatientContactRepositoryAdapter(PatientContactSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public PatientContact save(PatientContact entity) {
        PatientContactJpaEntity jpaEntity = new PatientContactJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        PatientContactJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<PatientContact> findById(PatientContactId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<PatientContact> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(PatientContactId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(PatientContactId id) {
        return repository.existsById(id.value());
    }

    private PatientContact toDomain(PatientContactJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new PatientContact(
                PatientContactId.of(jpa.getId()),
                PatientContactName.of(entityName),
                PatientContactStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
