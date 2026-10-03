package com.demodd.application.geography.country.service;

import com.demodd.application.geography.country.dto.CountryResponse;
import com.demodd.application.geography.country.port.in.CreateCountryUseCase;
import com.demodd.application.geography.country.port.in.DeleteCountryUseCase;
import com.demodd.application.geography.country.port.in.GetCountryUseCase;
import com.demodd.application.geography.country.port.in.UpdateCountryUseCase;
import com.demodd.domain.geography.country.exception.CountryNotFoundException;
import com.demodd.domain.geography.country.model.aggregate.Country;
import com.demodd.domain.geography.country.model.valueobject.CountryId;
import com.demodd.domain.geography.country.model.valueobject.CountryName;
import com.demodd.domain.geography.country.model.valueobject.CountryStatus;
import com.demodd.domain.geography.country.port.repository.CountryRepositoryPort;

import java.util.List;
import java.util.UUID;

public class CountryApplicationService implements
        CreateCountryUseCase,
        UpdateCountryUseCase,
        GetCountryUseCase,
        DeleteCountryUseCase {

    private final CountryRepositoryPort repository;

    public CountryApplicationService(CountryRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public CountryResponse execute(String name) {
        Country entity = Country.create(CountryName.of(name));
        Country saved = repository.save(entity);
        return CountryResponse.fromDomain(saved);
    }

    @Override
    public CountryResponse execute(UUID id, String name, String status) {
        CountryId entityId = CountryId.of(id);
        Country entity = repository.findById(entityId)
                .orElseThrow(() -> new CountryNotFoundException(entityId));

        entity.update(CountryName.of(name), CountryStatus.of(status));
        Country updated = repository.save(entity);
        return CountryResponse.fromDomain(updated);
    }

    @Override
    public CountryResponse getById(UUID id) {
        CountryId entityId = CountryId.of(id);
        return repository.findById(entityId)
                .map(CountryResponse::fromDomain)
                .orElseThrow(() -> new CountryNotFoundException(entityId));
    }

    @Override
    public List<CountryResponse> getAll() {
        return repository.findAll().stream()
                .map(CountryResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        CountryId entityId = CountryId.of(id);
        if (!repository.existsById(entityId)) {
            throw new CountryNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
