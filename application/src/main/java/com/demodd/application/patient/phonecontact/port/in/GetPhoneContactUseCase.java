package com.demodd.application.patient.phonecontact.port.in;

import com.demodd.application.patient.phonecontact.dto.PhoneContactResponse;

import java.util.List;
import java.util.UUID;

public interface GetPhoneContactUseCase {

    PhoneContactResponse getById(UUID id);

    List<PhoneContactResponse> getAll();
}
