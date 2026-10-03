package com.demodd.application.clinical.consenttype.port.in;

import com.demodd.application.clinical.consenttype.dto.ConsentTypeResponse;

import java.util.List;
import java.util.UUID;

public interface GetConsentTypeUseCase {

    ConsentTypeResponse getById(UUID id);

    List<ConsentTypeResponse> getAll();
}
