package com.demodd.application.geography.citymunicipality.port.in;

import com.demodd.application.geography.citymunicipality.dto.CityMunicipalityResponse;

import java.util.List;
import java.util.UUID;

public interface GetCityMunicipalityUseCase {

    CityMunicipalityResponse getById(UUID id);

    List<CityMunicipalityResponse> getAll();
}
