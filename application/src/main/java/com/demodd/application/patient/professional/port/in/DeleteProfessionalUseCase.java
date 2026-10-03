package com.demodd.application.patient.professional.port.in;

import java.util.UUID;

public interface DeleteProfessionalUseCase {

    void execute(UUID id);
}
