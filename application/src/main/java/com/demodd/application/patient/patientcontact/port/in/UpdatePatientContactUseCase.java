package com.demodd.application.patient.patientcontact.port.in;

import com.demodd.application.patient.patientcontact.dto.PatientContactResponse;

import java.util.UUID;

public interface UpdatePatientContactUseCase {

    PatientContactResponse execute(UUID id, String name, String status);
}
