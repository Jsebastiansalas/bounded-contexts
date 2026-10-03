package com.demodd.application.clinical.clinicalrecordstatus.port.in;

import com.demodd.application.clinical.clinicalrecordstatus.dto.ClinicalRecordStatusResponse;

import java.util.List;
import java.util.UUID;

public interface GetClinicalRecordStatusUseCase {

    ClinicalRecordStatusResponse getById(UUID id);

    List<ClinicalRecordStatusResponse> getAll();
}
