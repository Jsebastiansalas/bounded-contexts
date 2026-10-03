package com.demodd.domain.geography.citymunicipality.port.repository;

import com.demodd.domain.geography.citymunicipality.model.aggregate.CityMunicipality;
import com.demodd.domain.geography.citymunicipality.model.valueobject.CityMunicipalityId;

import java.util.List;
import java.util.Optional;

public interface CityMunicipalityRepositoryPort {

    CityMunicipality save(CityMunicipality entity);

    Optional<CityMunicipality> findById(CityMunicipalityId id);

    List<CityMunicipality> findAll();

    void deleteById(CityMunicipalityId id);

    boolean existsById(CityMunicipalityId id);
}
