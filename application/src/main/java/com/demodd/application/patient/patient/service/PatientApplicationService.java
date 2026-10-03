package com.demodd.application.patient.patient.service;

import com.demodd.application.patient.patient.dto.PatientResponse;
import com.demodd.application.patient.patient.port.in.CreatePatientUseCase;
import com.demodd.application.patient.patient.port.in.DeletePatientUseCase;
import com.demodd.application.patient.patient.port.in.GetPatientUseCase;
import com.demodd.application.patient.patient.port.in.UpdatePatientUseCase;
import com.demodd.domain.patient.patient.exception.PatientNotFoundException;
import com.demodd.domain.patient.patient.model.aggregate.Patient;
import com.demodd.domain.patient.patient.model.valueobject.PatientId;
import com.demodd.domain.patient.patient.model.valueobject.PatientName;
import com.demodd.domain.patient.patient.model.valueobject.PatientStatus;
import com.demodd.domain.patient.patient.port.repository.PatientRepositoryPort;

import java.util.List;
import java.util.UUID;

public class PatientApplicationService implements
        CreatePatientUseCase,
        UpdatePatientUseCase,
        GetPatientUseCase,
        DeletePatientUseCase {

    private final PatientRepositoryPort repository;

    public PatientApplicationService(PatientRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public PatientResponse execute(String name) {
        Patient entity = Patient.create(PatientName.of(name));
        Patient saved = repository.save(entity);
        return PatientResponse.fromDomain(saved);
    }

    @Override
    public PatientResponse execute(UUID id, String name, String status) {
        PatientId entityId = PatientId.of(id);
        Patient entity = repository.findById(entityId)
                .orElseThrow(() -> new PatientNotFoundException(entityId));

        entity.update(PatientName.of(name), PatientStatus.of(status));
        Patient updated = repository.save(entity);
        return PatientResponse.fromDomain(updated);
    }

    @Override
    public PatientResponse getById(UUID id) {
        PatientId entityId = PatientId.of(id);
        return repository.findById(entityId)
                .map(PatientResponse::fromDomain)
                .orElseThrow(() -> new PatientNotFoundException(entityId));
    }

    @Override
    public List<PatientResponse> getAll() {
        return repository.findAll().stream()
                .map(PatientResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        PatientId entityId = PatientId.of(id);
        if (!repository.existsById(entityId)) {
            throw new PatientNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
