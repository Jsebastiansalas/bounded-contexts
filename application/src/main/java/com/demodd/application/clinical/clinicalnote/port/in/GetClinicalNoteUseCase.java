package com.demodd.application.clinical.clinicalnote.port.in;

import com.demodd.application.clinical.clinicalnote.dto.ClinicalNoteResponse;

import java.util.List;
import java.util.UUID;

public interface GetClinicalNoteUseCase {

    ClinicalNoteResponse getById(UUID id);

    List<ClinicalNoteResponse> getAll();
}
