package com.demodd.application.clinical.clinicalrecord.port.in;

import com.demodd.application.clinical.clinicalrecord.dto.ClinicalRecordResponse;

public interface CreateClinicalRecordUseCase {

    ClinicalRecordResponse execute(String name);
}
