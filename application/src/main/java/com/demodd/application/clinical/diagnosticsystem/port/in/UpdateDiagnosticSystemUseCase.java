package com.demodd.application.clinical.diagnosticsystem.port.in;

import com.demodd.application.clinical.diagnosticsystem.dto.DiagnosticSystemResponse;

import java.util.UUID;

public interface UpdateDiagnosticSystemUseCase {

    DiagnosticSystemResponse execute(UUID id, String name, String status);
}
