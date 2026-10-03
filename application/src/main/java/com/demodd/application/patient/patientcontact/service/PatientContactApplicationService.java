package com.demodd.application.patient.patientcontact.service;

import com.demodd.application.patient.patientcontact.dto.PatientContactResponse;
import com.demodd.application.patient.patientcontact.port.in.CreatePatientContactUseCase;
import com.demodd.application.patient.patientcontact.port.in.DeletePatientContactUseCase;
import com.demodd.application.patient.patientcontact.port.in.GetPatientContactUseCase;
import com.demodd.application.patient.patientcontact.port.in.UpdatePatientContactUseCase;
import com.demodd.domain.patient.patientcontact.exception.PatientContactNotFoundException;
import com.demodd.domain.patient.patientcontact.model.aggregate.PatientContact;
import com.demodd.domain.patient.patientcontact.model.valueobject.PatientContactId;
import com.demodd.domain.patient.patientcontact.model.valueobject.PatientContactName;
import com.demodd.domain.patient.patientcontact.model.valueobject.PatientContactStatus;
import com.demodd.domain.patient.patientcontact.port.repository.PatientContactRepositoryPort;

import java.util.List;
import java.util.UUID;

public class PatientContactApplicationService implements
        CreatePatientContactUseCase,
        UpdatePatientContactUseCase,
        GetPatientContactUseCase,
        DeletePatientContactUseCase {

    private final PatientContactRepositoryPort repository;

    public PatientContactApplicationService(PatientContactRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public PatientContactResponse execute(String name) {
        PatientContact entity = PatientContact.create(PatientContactName.of(name));
        PatientContact saved = repository.save(entity);
        return PatientContactResponse.fromDomain(saved);
    }

    @Override
    public PatientContactResponse execute(UUID id, String name, String status) {
        PatientContactId entityId = PatientContactId.of(id);
        PatientContact entity = repository.findById(entityId)
                .orElseThrow(() -> new PatientContactNotFoundException(entityId));

        entity.update(PatientContactName.of(name), PatientContactStatus.of(status));
        PatientContact updated = repository.save(entity);
        return PatientContactResponse.fromDomain(updated);
    }

    @Override
    public PatientContactResponse getById(UUID id) {
        PatientContactId entityId = PatientContactId.of(id);
        return repository.findById(entityId)
                .map(PatientContactResponse::fromDomain)
                .orElseThrow(() -> new PatientContactNotFoundException(entityId));
    }

    @Override
    public List<PatientContactResponse> getAll() {
        return repository.findAll().stream()
                .map(PatientContactResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        PatientContactId entityId = PatientContactId.of(id);
        if (!repository.existsById(entityId)) {
            throw new PatientContactNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
