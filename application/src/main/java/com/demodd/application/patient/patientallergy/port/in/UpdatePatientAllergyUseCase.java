package com.demodd.application.patient.patientallergy.port.in;

import com.demodd.application.patient.patientallergy.dto.PatientAllergyResponse;

import java.util.UUID;

public interface UpdatePatientAllergyUseCase {

    PatientAllergyResponse execute(UUID id, String name, String status);
}
