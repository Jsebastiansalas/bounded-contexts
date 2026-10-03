package com.demodd.infrastructure.clinical.clinicalnote.adapter.in.web;

import com.demodd.application.clinical.clinicalnote.dto.ClinicalNoteResponse;
import com.demodd.application.clinical.clinicalnote.port.in.CreateClinicalNoteUseCase;
import com.demodd.application.clinical.clinicalnote.port.in.DeleteClinicalNoteUseCase;
import com.demodd.application.clinical.clinicalnote.port.in.GetClinicalNoteUseCase;
import com.demodd.application.clinical.clinicalnote.port.in.UpdateClinicalNoteUseCase;
import com.demodd.application.clinical.clinicalnote.service.ClinicalNoteApplicationService;
import com.demodd.domain.clinical.clinicalnote.port.repository.ClinicalNoteRepositoryPort;
import com.demodd.infrastructure.clinical.clinicalnote.adapter.in.web.dto.CreateClinicalNoteWebRequest;
import com.demodd.infrastructure.clinical.clinicalnote.adapter.in.web.dto.UpdateClinicalNoteWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinical/clinicalnote")
public class ClinicalNoteRestController {

    private final CreateClinicalNoteUseCase createUseCase;
    private final UpdateClinicalNoteUseCase updateUseCase;
    private final GetClinicalNoteUseCase getUseCase;
    private final DeleteClinicalNoteUseCase deleteUseCase;

    public ClinicalNoteRestController(ClinicalNoteRepositoryPort repository) {
        ClinicalNoteApplicationService service = new ClinicalNoteApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ClinicalNoteResponse> create(@RequestBody CreateClinicalNoteWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicalNoteResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClinicalNoteResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicalNoteResponse> update(@PathVariable UUID id, @RequestBody UpdateClinicalNoteWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
