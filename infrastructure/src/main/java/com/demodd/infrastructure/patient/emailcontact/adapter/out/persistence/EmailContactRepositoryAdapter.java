package com.demodd.infrastructure.patient.emailcontact.adapter.out.persistence;

import com.demodd.domain.patient.emailcontact.model.aggregate.EmailContact;
import com.demodd.domain.patient.emailcontact.model.valueobject.EmailContactId;
import com.demodd.domain.patient.emailcontact.model.valueobject.EmailContactName;
import com.demodd.domain.patient.emailcontact.model.valueobject.EmailContactStatus;
import com.demodd.domain.patient.emailcontact.port.repository.EmailContactRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmailContactRepositoryAdapter implements EmailContactRepositoryPort {

    private final EmailContactSpringDataJpaRepository repository;

    public EmailContactRepositoryAdapter(EmailContactSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmailContact save(EmailContact entity) {
        EmailContactJpaEntity jpaEntity = new EmailContactJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        EmailContactJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<EmailContact> findById(EmailContactId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<EmailContact> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(EmailContactId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(EmailContactId id) {
        return repository.existsById(id.value());
    }

    private EmailContact toDomain(EmailContactJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new EmailContact(
                EmailContactId.of(jpa.getId()),
                EmailContactName.of(entityName),
                EmailContactStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
