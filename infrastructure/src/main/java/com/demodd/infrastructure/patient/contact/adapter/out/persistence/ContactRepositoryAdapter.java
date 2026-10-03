package com.demodd.infrastructure.patient.contact.adapter.out.persistence;

import com.demodd.domain.patient.contact.model.aggregate.Contact;
import com.demodd.domain.patient.contact.model.valueobject.ContactId;
import com.demodd.domain.patient.contact.model.valueobject.ContactName;
import com.demodd.domain.patient.contact.model.valueobject.ContactStatus;
import com.demodd.domain.patient.contact.port.repository.ContactRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ContactRepositoryAdapter implements ContactRepositoryPort {

    private final ContactSpringDataJpaRepository repository;

    public ContactRepositoryAdapter(ContactSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contact save(Contact entity) {
        ContactJpaEntity jpaEntity = new ContactJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ContactJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<Contact> findById(ContactId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<Contact> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ContactId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ContactId id) {
        return repository.existsById(id.value());
    }

    private Contact toDomain(ContactJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new Contact(
                ContactId.of(jpa.getId()),
                ContactName.of(entityName),
                ContactStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
