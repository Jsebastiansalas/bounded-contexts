package com.demodd.application.patient.phonecontact.service;

import com.demodd.application.patient.phonecontact.dto.PhoneContactResponse;
import com.demodd.application.patient.phonecontact.port.in.CreatePhoneContactUseCase;
import com.demodd.application.patient.phonecontact.port.in.DeletePhoneContactUseCase;
import com.demodd.application.patient.phonecontact.port.in.GetPhoneContactUseCase;
import com.demodd.application.patient.phonecontact.port.in.UpdatePhoneContactUseCase;
import com.demodd.domain.patient.phonecontact.exception.PhoneContactNotFoundException;
import com.demodd.domain.patient.phonecontact.model.aggregate.PhoneContact;
import com.demodd.domain.patient.phonecontact.model.valueobject.PhoneContactId;
import com.demodd.domain.patient.phonecontact.model.valueobject.PhoneContactName;
import com.demodd.domain.patient.phonecontact.model.valueobject.PhoneContactStatus;
import com.demodd.domain.patient.phonecontact.port.repository.PhoneContactRepositoryPort;

import java.util.List;
import java.util.UUID;

public class PhoneContactApplicationService implements
        CreatePhoneContactUseCase,
        UpdatePhoneContactUseCase,
        GetPhoneContactUseCase,
        DeletePhoneContactUseCase {

    private final PhoneContactRepositoryPort repository;

    public PhoneContactApplicationService(PhoneContactRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public PhoneContactResponse execute(String name) {
        PhoneContact entity = PhoneContact.create(PhoneContactName.of(name));
        PhoneContact saved = repository.save(entity);
        return PhoneContactResponse.fromDomain(saved);
    }

    @Override
    public PhoneContactResponse execute(UUID id, String name, String status) {
        PhoneContactId entityId = PhoneContactId.of(id);
        PhoneContact entity = repository.findById(entityId)
                .orElseThrow(() -> new PhoneContactNotFoundException(entityId));

        entity.update(PhoneContactName.of(name), PhoneContactStatus.of(status));
        PhoneContact updated = repository.save(entity);
        return PhoneContactResponse.fromDomain(updated);
    }

    @Override
    public PhoneContactResponse getById(UUID id) {
        PhoneContactId entityId = PhoneContactId.of(id);
        return repository.findById(entityId)
                .map(PhoneContactResponse::fromDomain)
                .orElseThrow(() -> new PhoneContactNotFoundException(entityId));
    }

    @Override
    public List<PhoneContactResponse> getAll() {
        return repository.findAll().stream()
                .map(PhoneContactResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        PhoneContactId entityId = PhoneContactId.of(id);
        if (!repository.existsById(entityId)) {
            throw new PhoneContactNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
