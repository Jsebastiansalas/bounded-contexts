package com.demodd.application.patient.emailcontact.port.in;

import com.demodd.application.patient.emailcontact.dto.EmailContactResponse;

import java.util.UUID;

public interface UpdateEmailContactUseCase {

    EmailContactResponse execute(UUID id, String name, String status);
}
