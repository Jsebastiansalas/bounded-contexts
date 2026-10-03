package com.demodd.application.geography.country.port.in;

import com.demodd.application.geography.country.dto.CountryResponse;

public interface CreateCountryUseCase {

    CountryResponse execute(String name);
}
