package com.demodd.application.patient.phonecontact.port.in;

import com.demodd.application.patient.phonecontact.dto.PhoneContactResponse;

public interface CreatePhoneContactUseCase {

    PhoneContactResponse execute(String name);
}
