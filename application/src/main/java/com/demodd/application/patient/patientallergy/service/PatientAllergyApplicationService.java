package com.demodd.application.patient.patientallergy.service;

import com.demodd.application.patient.patientallergy.dto.PatientAllergyResponse;
import com.demodd.application.patient.patientallergy.port.in.CreatePatientAllergyUseCase;
import com.demodd.application.patient.patientallergy.port.in.DeletePatientAllergyUseCase;
import com.demodd.application.patient.patientallergy.port.in.GetPatientAllergyUseCase;
import com.demodd.application.patient.patientallergy.port.in.UpdatePatientAllergyUseCase;
import com.demodd.domain.patient.patientallergy.exception.PatientAllergyNotFoundException;
import com.demodd.domain.patient.patientallergy.model.aggregate.PatientAllergy;
import com.demodd.domain.patient.patientallergy.model.valueobject.PatientAllergyId;
import com.demodd.domain.patient.patientallergy.model.valueobject.PatientAllergyName;
import com.demodd.domain.patient.patientallergy.model.valueobject.PatientAllergyStatus;
import com.demodd.domain.patient.patientallergy.port.repository.PatientAllergyRepositoryPort;

import java.util.List;
import java.util.UUID;

public class PatientAllergyApplicationService implements
        CreatePatientAllergyUseCase,
        UpdatePatientAllergyUseCase,
        GetPatientAllergyUseCase,
        DeletePatientAllergyUseCase {

    private final PatientAllergyRepositoryPort repository;

    public PatientAllergyApplicationService(PatientAllergyRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public PatientAllergyResponse execute(String name) {
        PatientAllergy entity = PatientAllergy.create(PatientAllergyName.of(name));
        PatientAllergy saved = repository.save(entity);
        return PatientAllergyResponse.fromDomain(saved);
    }

    @Override
    public PatientAllergyResponse execute(UUID id, String name, String status) {
        PatientAllergyId entityId = PatientAllergyId.of(id);
        PatientAllergy entity = repository.findById(entityId)
                .orElseThrow(() -> new PatientAllergyNotFoundException(entityId));

        entity.update(PatientAllergyName.of(name), PatientAllergyStatus.of(status));
        PatientAllergy updated = repository.save(entity);
        return PatientAllergyResponse.fromDomain(updated);
    }

    @Override
    public PatientAllergyResponse getById(UUID id) {
        PatientAllergyId entityId = PatientAllergyId.of(id);
        return repository.findById(entityId)
                .map(PatientAllergyResponse::fromDomain)
                .orElseThrow(() -> new PatientAllergyNotFoundException(entityId));
    }

    @Override
    public List<PatientAllergyResponse> getAll() {
        return repository.findAll().stream()
                .map(PatientAllergyResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        PatientAllergyId entityId = PatientAllergyId.of(id);
        if (!repository.existsById(entityId)) {
            throw new PatientAllergyNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
