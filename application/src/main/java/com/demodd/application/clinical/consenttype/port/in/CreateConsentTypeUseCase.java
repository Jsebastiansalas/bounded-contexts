package com.demodd.application.clinical.consenttype.port.in;

import com.demodd.application.clinical.consenttype.dto.ConsentTypeResponse;

public interface CreateConsentTypeUseCase {

    ConsentTypeResponse execute(String name);
}
