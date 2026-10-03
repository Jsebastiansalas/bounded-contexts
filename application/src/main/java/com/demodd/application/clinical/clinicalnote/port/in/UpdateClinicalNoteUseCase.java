package com.demodd.application.clinical.clinicalnote.port.in;

import com.demodd.application.clinical.clinicalnote.dto.ClinicalNoteResponse;

import java.util.UUID;

public interface UpdateClinicalNoteUseCase {

    ClinicalNoteResponse execute(UUID id, String name, String status);
}
