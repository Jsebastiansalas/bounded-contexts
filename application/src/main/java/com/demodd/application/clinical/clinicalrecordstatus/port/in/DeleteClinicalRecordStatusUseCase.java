package com.demodd.application.clinical.clinicalrecordstatus.port.in;

import java.util.UUID;

public interface DeleteClinicalRecordStatusUseCase {

    void execute(UUID id);
}
