package com.demodd.application.clinical.clinicalrecordstatus.port.in;

import com.demodd.application.clinical.clinicalrecordstatus.dto.ClinicalRecordStatusResponse;

import java.util.UUID;

public interface UpdateClinicalRecordStatusUseCase {

    ClinicalRecordStatusResponse execute(UUID id, String name, String status);
}
