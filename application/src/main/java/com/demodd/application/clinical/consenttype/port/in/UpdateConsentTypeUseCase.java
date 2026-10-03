package com.demodd.application.clinical.consenttype.port.in;

import com.demodd.application.clinical.consenttype.dto.ConsentTypeResponse;

import java.util.UUID;

public interface UpdateConsentTypeUseCase {

    ConsentTypeResponse execute(UUID id, String name, String status);
}
