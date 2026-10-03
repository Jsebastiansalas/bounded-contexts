package com.demodd.application.clinical.clinicalrecord.port.in;

import com.demodd.application.clinical.clinicalrecord.dto.ClinicalRecordResponse;

import java.util.UUID;

public interface UpdateClinicalRecordUseCase {

    ClinicalRecordResponse execute(UUID id, String name, String status);
}
