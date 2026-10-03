package com.demodd.application.patient.contact.port.in;

import com.demodd.application.patient.contact.dto.ContactResponse;

import java.util.List;
import java.util.UUID;

public interface GetContactUseCase {

    ContactResponse getById(UUID id);

    List<ContactResponse> getAll();
}
