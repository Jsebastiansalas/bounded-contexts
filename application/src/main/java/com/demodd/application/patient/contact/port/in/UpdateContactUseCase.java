package com.demodd.application.patient.contact.port.in;

import com.demodd.application.patient.contact.dto.ContactResponse;

import java.util.UUID;

public interface UpdateContactUseCase {

    ContactResponse execute(UUID id, String name, String status);
}
