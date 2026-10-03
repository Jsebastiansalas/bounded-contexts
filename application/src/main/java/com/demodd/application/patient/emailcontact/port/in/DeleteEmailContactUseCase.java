package com.demodd.application.patient.emailcontact.port.in;

import java.util.UUID;

public interface DeleteEmailContactUseCase {

    void execute(UUID id);
}
