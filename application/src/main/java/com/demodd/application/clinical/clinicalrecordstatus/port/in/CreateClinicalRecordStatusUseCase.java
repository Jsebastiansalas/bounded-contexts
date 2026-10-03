package com.demodd.application.clinical.clinicalrecordstatus.port.in;

import com.demodd.application.clinical.clinicalrecordstatus.dto.ClinicalRecordStatusResponse;

public interface CreateClinicalRecordStatusUseCase {

    ClinicalRecordStatusResponse execute(String name);
}
