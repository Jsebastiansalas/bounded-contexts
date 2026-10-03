package com.demodd.application.clinical.clinicalrecord.port.in;

import com.demodd.application.clinical.clinicalrecord.dto.ClinicalRecordResponse;

import java.util.List;
import java.util.UUID;

public interface GetClinicalRecordUseCase {

    ClinicalRecordResponse getById(UUID id);

    List<ClinicalRecordResponse> getAll();
}
