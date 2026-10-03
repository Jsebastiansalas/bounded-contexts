package com.demodd.application.geography.citymunicipality.port.in;

import com.demodd.application.geography.citymunicipality.dto.CityMunicipalityResponse;

public interface CreateCityMunicipalityUseCase {

    CityMunicipalityResponse execute(String name);
}
