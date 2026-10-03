package com.demodd.application.clinical.treatmentstatus.port.in;

import java.util.UUID;

public interface DeleteTreatmentStatusUseCase {

    void execute(UUID id);
}
