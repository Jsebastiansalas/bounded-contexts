package com.demodd.infrastructure.clinical.diagnosticsystem.adapter.in.web;

import com.demodd.application.clinical.diagnosticsystem.dto.DiagnosticSystemResponse;
import com.demodd.application.clinical.diagnosticsystem.port.in.CreateDiagnosticSystemUseCase;
import com.demodd.application.clinical.diagnosticsystem.port.in.DeleteDiagnosticSystemUseCase;
import com.demodd.application.clinical.diagnosticsystem.port.in.GetDiagnosticSystemUseCase;
import com.demodd.application.clinical.diagnosticsystem.port.in.UpdateDiagnosticSystemUseCase;
import com.demodd.application.clinical.diagnosticsystem.service.DiagnosticSystemApplicationService;
import com.demodd.domain.clinical.diagnosticsystem.port.repository.DiagnosticSystemRepositoryPort;
import com.demodd.infrastructure.clinical.diagnosticsystem.adapter.in.web.dto.CreateDiagnosticSystemWebRequest;
import com.demodd.infrastructure.clinical.diagnosticsystem.adapter.in.web.dto.UpdateDiagnosticSystemWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinical/diagnosticsystem")
public class DiagnosticSystemRestController {

    private final CreateDiagnosticSystemUseCase createUseCase;
    private final UpdateDiagnosticSystemUseCase updateUseCase;
    private final GetDiagnosticSystemUseCase getUseCase;
    private final DeleteDiagnosticSystemUseCase deleteUseCase;

    public DiagnosticSystemRestController(DiagnosticSystemRepositoryPort repository) {
        DiagnosticSystemApplicationService service = new DiagnosticSystemApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<DiagnosticSystemResponse> create(@RequestBody CreateDiagnosticSystemWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiagnosticSystemResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DiagnosticSystemResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiagnosticSystemResponse> update(@PathVariable UUID id, @RequestBody UpdateDiagnosticSystemWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
