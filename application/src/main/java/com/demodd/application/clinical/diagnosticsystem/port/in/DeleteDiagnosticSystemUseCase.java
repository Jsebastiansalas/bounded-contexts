package com.demodd.application.clinical.diagnosticsystem.port.in;

import java.util.UUID;

public interface DeleteDiagnosticSystemUseCase {

    void execute(UUID id);
}
