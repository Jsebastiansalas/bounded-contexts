package com.demodd.application.clinical.medicationroute.service;

import com.demodd.application.clinical.medicationroute.dto.MedicationRouteResponse;
import com.demodd.application.clinical.medicationroute.port.in.CreateMedicationRouteUseCase;
import com.demodd.application.clinical.medicationroute.port.in.DeleteMedicationRouteUseCase;
import com.demodd.application.clinical.medicationroute.port.in.GetMedicationRouteUseCase;
import com.demodd.application.clinical.medicationroute.port.in.UpdateMedicationRouteUseCase;
import com.demodd.domain.clinical.medicationroute.exception.MedicationRouteNotFoundException;
import com.demodd.domain.clinical.medicationroute.model.aggregate.MedicationRoute;
import com.demodd.domain.clinical.medicationroute.model.valueobject.MedicationRouteId;
import com.demodd.domain.clinical.medicationroute.model.valueobject.MedicationRouteName;
import com.demodd.domain.clinical.medicationroute.model.valueobject.MedicationRouteStatus;
import com.demodd.domain.clinical.medicationroute.port.repository.MedicationRouteRepositoryPort;

import java.util.List;
import java.util.UUID;

public class MedicationRouteApplicationService implements
        CreateMedicationRouteUseCase,
        UpdateMedicationRouteUseCase,
        GetMedicationRouteUseCase,
        DeleteMedicationRouteUseCase {

    private final MedicationRouteRepositoryPort repository;

    public MedicationRouteApplicationService(MedicationRouteRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public MedicationRouteResponse execute(String name) {
        MedicationRoute entity = MedicationRoute.create(MedicationRouteName.of(name));
        MedicationRoute saved = repository.save(entity);
        return MedicationRouteResponse.fromDomain(saved);
    }

    @Override
    public MedicationRouteResponse execute(UUID id, String name, String status) {
        MedicationRouteId entityId = MedicationRouteId.of(id);
        MedicationRoute entity = repository.findById(entityId)
                .orElseThrow(() -> new MedicationRouteNotFoundException(entityId));

        entity.update(MedicationRouteName.of(name), MedicationRouteStatus.of(status));
        MedicationRoute updated = repository.save(entity);
        return MedicationRouteResponse.fromDomain(updated);
    }

    @Override
    public MedicationRouteResponse getById(UUID id) {
        MedicationRouteId entityId = MedicationRouteId.of(id);
        return repository.findById(entityId)
                .map(MedicationRouteResponse::fromDomain)
                .orElseThrow(() -> new MedicationRouteNotFoundException(entityId));
    }

    @Override
    public List<MedicationRouteResponse> getAll() {
        return repository.findAll().stream()
                .map(MedicationRouteResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        MedicationRouteId entityId = MedicationRouteId.of(id);
        if (!repository.existsById(entityId)) {
            throw new MedicationRouteNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
