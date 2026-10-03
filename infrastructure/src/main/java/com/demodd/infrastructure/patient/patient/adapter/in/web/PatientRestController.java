package com.demodd.infrastructure.patient.patient.adapter.in.web;

import com.demodd.application.patient.patient.dto.PatientResponse;
import com.demodd.application.patient.patient.port.in.CreatePatientUseCase;
import com.demodd.application.patient.patient.port.in.DeletePatientUseCase;
import com.demodd.application.patient.patient.port.in.GetPatientUseCase;
import com.demodd.application.patient.patient.port.in.UpdatePatientUseCase;
import com.demodd.application.patient.patient.service.PatientApplicationService;
import com.demodd.domain.patient.patient.port.repository.PatientRepositoryPort;
import com.demodd.infrastructure.patient.patient.adapter.in.web.dto.CreatePatientWebRequest;
import com.demodd.infrastructure.patient.patient.adapter.in.web.dto.UpdatePatientWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/patient/patient")
public class PatientRestController {

    private final CreatePatientUseCase createUseCase;
    private final UpdatePatientUseCase updateUseCase;
    private final GetPatientUseCase getUseCase;
    private final DeletePatientUseCase deleteUseCase;

    public PatientRestController(PatientRepositoryPort repository) {
        PatientApplicationService service = new PatientApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<PatientResponse> create(@RequestBody CreatePatientWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> update(@PathVariable UUID id, @RequestBody UpdatePatientWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
