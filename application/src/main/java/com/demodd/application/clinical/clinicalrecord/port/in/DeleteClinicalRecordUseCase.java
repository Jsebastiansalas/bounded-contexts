package com.demodd.application.clinical.clinicalrecord.port.in;

import java.util.UUID;

public interface DeleteClinicalRecordUseCase {

    void execute(UUID id);
}
