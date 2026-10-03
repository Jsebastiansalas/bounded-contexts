package com.demodd.domain.geography.country.port.repository;

import com.demodd.domain.geography.country.model.aggregate.Country;
import com.demodd.domain.geography.country.model.valueobject.CountryId;

import java.util.List;
import java.util.Optional;

public interface CountryRepositoryPort {

    Country save(Country entity);

    Optional<Country> findById(CountryId id);

    List<Country> findAll();

    void deleteById(CountryId id);

    boolean existsById(CountryId id);
}
