package com.demodd.application.patient.patientcontact.port.in;

import com.demodd.application.patient.patientcontact.dto.PatientContactResponse;

public interface CreatePatientContactUseCase {

    PatientContactResponse execute(String name);
}
