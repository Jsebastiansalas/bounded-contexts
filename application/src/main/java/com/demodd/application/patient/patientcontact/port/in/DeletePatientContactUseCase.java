package com.demodd.application.patient.patientcontact.port.in;

import java.util.UUID;

public interface DeletePatientContactUseCase {

    void execute(UUID id);
}
