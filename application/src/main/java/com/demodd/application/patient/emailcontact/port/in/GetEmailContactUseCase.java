package com.demodd.application.patient.emailcontact.port.in;

import com.demodd.application.patient.emailcontact.dto.EmailContactResponse;

import java.util.List;
import java.util.UUID;

public interface GetEmailContactUseCase {

    EmailContactResponse getById(UUID id);

    List<EmailContactResponse> getAll();
}
