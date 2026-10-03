package com.demodd.application.patient.contact.service;

import com.demodd.application.patient.contact.dto.ContactResponse;
import com.demodd.application.patient.contact.port.in.CreateContactUseCase;
import com.demodd.application.patient.contact.port.in.DeleteContactUseCase;
import com.demodd.application.patient.contact.port.in.GetContactUseCase;
import com.demodd.application.patient.contact.port.in.UpdateContactUseCase;
import com.demodd.domain.patient.contact.exception.ContactNotFoundException;
import com.demodd.domain.patient.contact.model.aggregate.Contact;
import com.demodd.domain.patient.contact.model.valueobject.ContactId;
import com.demodd.domain.patient.contact.model.valueobject.ContactName;
import com.demodd.domain.patient.contact.model.valueobject.ContactStatus;
import com.demodd.domain.patient.contact.port.repository.ContactRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ContactApplicationService implements
        CreateContactUseCase,
        UpdateContactUseCase,
        GetContactUseCase,
        DeleteContactUseCase {

    private final ContactRepositoryPort repository;

    public ContactApplicationService(ContactRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ContactResponse execute(String name) {
        Contact entity = Contact.create(ContactName.of(name));
        Contact saved = repository.save(entity);
        return ContactResponse.fromDomain(saved);
    }

    @Override
    public ContactResponse execute(UUID id, String name, String status) {
        ContactId entityId = ContactId.of(id);
        Contact entity = repository.findById(entityId)
                .orElseThrow(() -> new ContactNotFoundException(entityId));

        entity.update(ContactName.of(name), ContactStatus.of(status));
        Contact updated = repository.save(entity);
        return ContactResponse.fromDomain(updated);
    }

    @Override
    public ContactResponse getById(UUID id) {
        ContactId entityId = ContactId.of(id);
        return repository.findById(entityId)
                .map(ContactResponse::fromDomain)
                .orElseThrow(() -> new ContactNotFoundException(entityId));
    }

    @Override
    public List<ContactResponse> getAll() {
        return repository.findAll().stream()
                .map(ContactResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ContactId entityId = ContactId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ContactNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
