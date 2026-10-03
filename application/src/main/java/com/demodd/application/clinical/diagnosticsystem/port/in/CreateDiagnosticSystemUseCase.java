package com.demodd.application.clinical.diagnosticsystem.port.in;

import com.demodd.application.clinical.diagnosticsystem.dto.DiagnosticSystemResponse;

public interface CreateDiagnosticSystemUseCase {

    DiagnosticSystemResponse execute(String name);
}
