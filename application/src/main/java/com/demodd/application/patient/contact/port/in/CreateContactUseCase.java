package com.demodd.application.patient.contact.port.in;

import com.demodd.application.patient.contact.dto.ContactResponse;

public interface CreateContactUseCase {

    ContactResponse execute(String name);
}
