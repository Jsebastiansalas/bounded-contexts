package com.demodd.application.geography.citymunicipality.port.in;

import com.demodd.application.geography.citymunicipality.dto.CityMunicipalityResponse;

import java.util.UUID;

public interface UpdateCityMunicipalityUseCase {

    CityMunicipalityResponse execute(UUID id, String name, String status);
}
