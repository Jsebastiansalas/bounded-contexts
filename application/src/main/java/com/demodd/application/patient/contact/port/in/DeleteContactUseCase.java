package com.demodd.application.patient.contact.port.in;

import java.util.UUID;

public interface DeleteContactUseCase {

    void execute(UUID id);
}
