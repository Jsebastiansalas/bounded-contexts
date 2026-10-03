package com.demodd.application.patient.phonecontact.port.in;

import java.util.UUID;

public interface DeletePhoneContactUseCase {

    void execute(UUID id);
}
