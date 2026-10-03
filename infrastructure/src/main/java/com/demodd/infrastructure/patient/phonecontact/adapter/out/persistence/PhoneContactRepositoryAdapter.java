package com.demodd.infrastructure.patient.phonecontact.adapter.out.persistence;

import com.demodd.domain.patient.phonecontact.model.aggregate.PhoneContact;
import com.demodd.domain.patient.phonecontact.model.valueobject.PhoneContactId;
import com.demodd.domain.patient.phonecontact.model.valueobject.PhoneContactName;
import com.demodd.domain.patient.phonecontact.model.valueobject.PhoneContactStatus;
import com.demodd.domain.patient.phonecontact.port.repository.PhoneContactRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PhoneContactRepositoryAdapter implements PhoneContactRepositoryPort {

    private final PhoneContactSpringDataJpaRepository repository;

    public PhoneContactRepositoryAdapter(PhoneContactSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public PhoneContact save(PhoneContact entity) {
        PhoneContactJpaEntity jpaEntity = new PhoneContactJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        PhoneContactJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<PhoneContact> findById(PhoneContactId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<PhoneContact> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(PhoneContactId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(PhoneContactId id) {
        return repository.existsById(id.value());
    }

    private PhoneContact toDomain(PhoneContactJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new PhoneContact(
                PhoneContactId.of(jpa.getId()),
                PhoneContactName.of(entityName),
                PhoneContactStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
