package com.demodd.application.patient.phonecontact.port.in;

import com.demodd.application.patient.phonecontact.dto.PhoneContactResponse;

import java.util.UUID;

public interface UpdatePhoneContactUseCase {

    PhoneContactResponse execute(UUID id, String name, String status);
}
