package com.demodd.application.patient.patient.port.in;

import java.util.UUID;

public interface DeletePatientUseCase {

    void execute(UUID id);
}
