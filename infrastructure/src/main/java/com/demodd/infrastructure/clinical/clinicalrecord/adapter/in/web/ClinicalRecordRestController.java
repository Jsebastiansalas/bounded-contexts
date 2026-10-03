package com.demodd.infrastructure.clinical.clinicalrecord.adapter.in.web;

import com.demodd.application.clinical.clinicalrecord.dto.ClinicalRecordResponse;
import com.demodd.application.clinical.clinicalrecord.port.in.CreateClinicalRecordUseCase;
import com.demodd.application.clinical.clinicalrecord.port.in.DeleteClinicalRecordUseCase;
import com.demodd.application.clinical.clinicalrecord.port.in.GetClinicalRecordUseCase;
import com.demodd.application.clinical.clinicalrecord.port.in.UpdateClinicalRecordUseCase;
import com.demodd.application.clinical.clinicalrecord.service.ClinicalRecordApplicationService;
import com.demodd.domain.clinical.clinicalrecord.port.repository.ClinicalRecordRepositoryPort;
import com.demodd.infrastructure.clinical.clinicalrecord.adapter.in.web.dto.CreateClinicalRecordWebRequest;
import com.demodd.infrastructure.clinical.clinicalrecord.adapter.in.web.dto.UpdateClinicalRecordWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinical/clinicalrecord")
public class ClinicalRecordRestController {

    private final CreateClinicalRecordUseCase createUseCase;
    private final UpdateClinicalRecordUseCase updateUseCase;
    private final GetClinicalRecordUseCase getUseCase;
    private final DeleteClinicalRecordUseCase deleteUseCase;

    public ClinicalRecordRestController(ClinicalRecordRepositoryPort repository) {
        ClinicalRecordApplicationService service = new ClinicalRecordApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ClinicalRecordResponse> create(@RequestBody CreateClinicalRecordWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicalRecordResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClinicalRecordResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicalRecordResponse> update(@PathVariable UUID id, @RequestBody UpdateClinicalRecordWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
