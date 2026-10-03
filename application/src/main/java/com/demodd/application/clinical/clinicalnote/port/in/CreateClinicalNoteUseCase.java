package com.demodd.application.clinical.clinicalnote.port.in;

import com.demodd.application.clinical.clinicalnote.dto.ClinicalNoteResponse;

public interface CreateClinicalNoteUseCase {

    ClinicalNoteResponse execute(String name);
}
