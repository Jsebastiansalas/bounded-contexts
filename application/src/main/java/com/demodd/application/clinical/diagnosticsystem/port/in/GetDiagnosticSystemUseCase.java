package com.demodd.application.clinical.diagnosticsystem.port.in;

import com.demodd.application.clinical.diagnosticsystem.dto.DiagnosticSystemResponse;

import java.util.List;
import java.util.UUID;

public interface GetDiagnosticSystemUseCase {

    DiagnosticSystemResponse getById(UUID id);

    List<DiagnosticSystemResponse> getAll();
}
