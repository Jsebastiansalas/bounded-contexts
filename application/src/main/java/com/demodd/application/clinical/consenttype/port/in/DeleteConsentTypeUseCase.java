package com.demodd.application.clinical.consenttype.port.in;

import java.util.UUID;

public interface DeleteConsentTypeUseCase {

    void execute(UUID id);
}
