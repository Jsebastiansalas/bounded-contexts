package com.demodd.application.patient.emailcontact.port.in;

import com.demodd.application.patient.emailcontact.dto.EmailContactResponse;

public interface CreateEmailContactUseCase {

    EmailContactResponse execute(String name);
}
