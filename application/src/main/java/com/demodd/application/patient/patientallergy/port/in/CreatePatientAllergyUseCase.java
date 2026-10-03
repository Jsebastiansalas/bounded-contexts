package com.demodd.application.patient.patientallergy.port.in;

import com.demodd.application.patient.patientallergy.dto.PatientAllergyResponse;

public interface CreatePatientAllergyUseCase {

    PatientAllergyResponse execute(String name);
}
