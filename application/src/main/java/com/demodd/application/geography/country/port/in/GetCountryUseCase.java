package com.demodd.application.geography.country.port.in;

import com.demodd.application.geography.country.dto.CountryResponse;

import java.util.List;
import java.util.UUID;

public interface GetCountryUseCase {

    CountryResponse getById(UUID id);

    List<CountryResponse> getAll();
}
