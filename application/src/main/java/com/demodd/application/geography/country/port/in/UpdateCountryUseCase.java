package com.demodd.application.geography.country.port.in;

import com.demodd.application.geography.country.dto.CountryResponse;

import java.util.UUID;

public interface UpdateCountryUseCase {

    CountryResponse execute(UUID id, String name, String status);
}
