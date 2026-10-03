package com.demodd.application.clinical.clinicalnote.port.in;

import java.util.UUID;

public interface DeleteClinicalNoteUseCase {

    void execute(UUID id);
}
