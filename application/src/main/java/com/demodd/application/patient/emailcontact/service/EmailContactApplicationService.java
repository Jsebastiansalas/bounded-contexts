package com.demodd.application.patient.emailcontact.service;

import com.demodd.application.patient.emailcontact.dto.EmailContactResponse;
import com.demodd.application.patient.emailcontact.port.in.CreateEmailContactUseCase;
import com.demodd.application.patient.emailcontact.port.in.DeleteEmailContactUseCase;
import com.demodd.application.patient.emailcontact.port.in.GetEmailContactUseCase;
import com.demodd.application.patient.emailcontact.port.in.UpdateEmailContactUseCase;
import com.demodd.domain.patient.emailcontact.exception.EmailContactNotFoundException;
import com.demodd.domain.patient.emailcontact.model.aggregate.EmailContact;
import com.demodd.domain.patient.emailcontact.model.valueobject.EmailContactId;
import com.demodd.domain.patient.emailcontact.model.valueobject.EmailContactName;
import com.demodd.domain.patient.emailcontact.model.valueobject.EmailContactStatus;
import com.demodd.domain.patient.emailcontact.port.repository.EmailContactRepositoryPort;

import java.util.List;
import java.util.UUID;

public class EmailContactApplicationService implements
        CreateEmailContactUseCase,
        UpdateEmailContactUseCase,
        GetEmailContactUseCase,
        DeleteEmailContactUseCase {

    private final EmailContactRepositoryPort repository;

    public EmailContactApplicationService(EmailContactRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public EmailContactResponse execute(String name) {
        EmailContact entity = EmailContact.create(EmailContactName.of(name));
        EmailContact saved = repository.save(entity);
        return EmailContactResponse.fromDomain(saved);
    }

    @Override
    public EmailContactResponse execute(UUID id, String name, String status) {
        EmailContactId entityId = EmailContactId.of(id);
        EmailContact entity = repository.findById(entityId)
                .orElseThrow(() -> new EmailContactNotFoundException(entityId));

        entity.update(EmailContactName.of(name), EmailContactStatus.of(status));
        EmailContact updated = repository.save(entity);
        return EmailContactResponse.fromDomain(updated);
    }

    @Override
    public EmailContactResponse getById(UUID id) {
        EmailContactId entityId = EmailContactId.of(id);
        return repository.findById(entityId)
                .map(EmailContactResponse::fromDomain)
                .orElseThrow(() -> new EmailContactNotFoundException(entityId));
    }

    @Override
    public List<EmailContactResponse> getAll() {
        return repository.findAll().stream()
                .map(EmailContactResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        EmailContactId entityId = EmailContactId.of(id);
        if (!repository.existsById(entityId)) {
            throw new EmailContactNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
