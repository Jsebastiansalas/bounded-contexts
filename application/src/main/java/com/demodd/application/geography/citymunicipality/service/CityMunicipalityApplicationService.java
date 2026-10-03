package com.demodd.application.geography.citymunicipality.service;

import com.demodd.application.geography.citymunicipality.dto.CityMunicipalityResponse;
import com.demodd.application.geography.citymunicipality.port.in.CreateCityMunicipalityUseCase;
import com.demodd.application.geography.citymunicipality.port.in.DeleteCityMunicipalityUseCase;
import com.demodd.application.geography.citymunicipality.port.in.GetCityMunicipalityUseCase;
import com.demodd.application.geography.citymunicipality.port.in.UpdateCityMunicipalityUseCase;
import com.demodd.domain.geography.citymunicipality.exception.CityMunicipalityNotFoundException;
import com.demodd.domain.geography.citymunicipality.model.aggregate.CityMunicipality;
import com.demodd.domain.geography.citymunicipality.model.valueobject.CityMunicipalityId;
import com.demodd.domain.geography.citymunicipality.model.valueobject.CityMunicipalityName;
import com.demodd.domain.geography.citymunicipality.model.valueobject.CityMunicipalityStatus;
import com.demodd.domain.geography.citymunicipality.port.repository.CityMunicipalityRepositoryPort;

import java.util.List;
import java.util.UUID;

public class CityMunicipalityApplicationService implements
        CreateCityMunicipalityUseCase,
        UpdateCityMunicipalityUseCase,
        GetCityMunicipalityUseCase,
        DeleteCityMunicipalityUseCase {

    private final CityMunicipalityRepositoryPort repository;

    public CityMunicipalityApplicationService(CityMunicipalityRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public CityMunicipalityResponse execute(String name) {
        CityMunicipality entity = CityMunicipality.create(CityMunicipalityName.of(name));
        CityMunicipality saved = repository.save(entity);
        return CityMunicipalityResponse.fromDomain(saved);
    }

    @Override
    public CityMunicipalityResponse execute(UUID id, String name, String status) {
        CityMunicipalityId entityId = CityMunicipalityId.of(id);
        CityMunicipality entity = repository.findById(entityId)
                .orElseThrow(() -> new CityMunicipalityNotFoundException(entityId));

        entity.update(CityMunicipalityName.of(name), CityMunicipalityStatus.of(status));
        CityMunicipality updated = repository.save(entity);
        return CityMunicipalityResponse.fromDomain(updated);
    }

    @Override
    public CityMunicipalityResponse getById(UUID id) {
        CityMunicipalityId entityId = CityMunicipalityId.of(id);
        return repository.findById(entityId)
                .map(CityMunicipalityResponse::fromDomain)
                .orElseThrow(() -> new CityMunicipalityNotFoundException(entityId));
    }

    @Override
    public List<CityMunicipalityResponse> getAll() {
        return repository.findAll().stream()
                .map(CityMunicipalityResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        CityMunicipalityId entityId = CityMunicipalityId.of(id);
        if (!repository.existsById(entityId)) {
            throw new CityMunicipalityNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
