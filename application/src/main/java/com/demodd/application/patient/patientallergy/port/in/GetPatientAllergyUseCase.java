package com.demodd.application.patient.patientallergy.port.in;

import com.demodd.application.patient.patientallergy.dto.PatientAllergyResponse;

import java.util.List;
import java.util.UUID;

public interface GetPatientAllergyUseCase {

    PatientAllergyResponse getById(UUID id);

    List<PatientAllergyResponse> getAll();
}
