package com.demodd.infrastructure.clinical.clinicalrecordstatus.adapter.in.web;

import com.demodd.application.clinical.clinicalrecordstatus.dto.ClinicalRecordStatusResponse;
import com.demodd.application.clinical.clinicalrecordstatus.port.in.CreateClinicalRecordStatusUseCase;
import com.demodd.application.clinical.clinicalrecordstatus.port.in.DeleteClinicalRecordStatusUseCase;
import com.demodd.application.clinical.clinicalrecordstatus.port.in.GetClinicalRecordStatusUseCase;
import com.demodd.application.clinical.clinicalrecordstatus.port.in.UpdateClinicalRecordStatusUseCase;
import com.demodd.application.clinical.clinicalrecordstatus.service.ClinicalRecordStatusApplicationService;
import com.demodd.domain.clinical.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepositoryPort;
import com.demodd.infrastructure.clinical.clinicalrecordstatus.adapter.in.web.dto.CreateClinicalRecordStatusWebRequest;
import com.demodd.infrastructure.clinical.clinicalrecordstatus.adapter.in.web.dto.UpdateClinicalRecordStatusWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinical/clinicalrecordstatus")
public class ClinicalRecordStatusRestController {

    private final CreateClinicalRecordStatusUseCase createUseCase;
    private final UpdateClinicalRecordStatusUseCase updateUseCase;
    private final GetClinicalRecordStatusUseCase getUseCase;
    private final DeleteClinicalRecordStatusUseCase deleteUseCase;

    public ClinicalRecordStatusRestController(ClinicalRecordStatusRepositoryPort repository) {
        ClinicalRecordStatusApplicationService service = new ClinicalRecordStatusApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ClinicalRecordStatusResponse> create(@RequestBody CreateClinicalRecordStatusWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicalRecordStatusResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClinicalRecordStatusResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicalRecordStatusResponse> update(@PathVariable UUID id, @RequestBody UpdateClinicalRecordStatusWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
