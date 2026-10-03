package com.demodd.infrastructure.clinical.treatmentstatus.adapter.in.web;

import com.demodd.application.clinical.treatmentstatus.dto.TreatmentStatusResponse;
import com.demodd.application.clinical.treatmentstatus.port.in.CreateTreatmentStatusUseCase;
import com.demodd.application.clinical.treatmentstatus.port.in.DeleteTreatmentStatusUseCase;
import com.demodd.application.clinical.treatmentstatus.port.in.GetTreatmentStatusUseCase;
import com.demodd.application.clinical.treatmentstatus.port.in.UpdateTreatmentStatusUseCase;
import com.demodd.application.clinical.treatmentstatus.service.TreatmentStatusApplicationService;
import com.demodd.domain.clinical.treatmentstatus.port.repository.TreatmentStatusRepositoryPort;
import com.demodd.infrastructure.clinical.treatmentstatus.adapter.in.web.dto.CreateTreatmentStatusWebRequest;
import com.demodd.infrastructure.clinical.treatmentstatus.adapter.in.web.dto.UpdateTreatmentStatusWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinical/treatmentstatus")
public class TreatmentStatusRestController {

    private final CreateTreatmentStatusUseCase createUseCase;
    private final UpdateTreatmentStatusUseCase updateUseCase;
    private final GetTreatmentStatusUseCase getUseCase;
    private final DeleteTreatmentStatusUseCase deleteUseCase;

    public TreatmentStatusRestController(TreatmentStatusRepositoryPort repository) {
        TreatmentStatusApplicationService service = new TreatmentStatusApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<TreatmentStatusResponse> create(@RequestBody CreateTreatmentStatusWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreatmentStatusResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<TreatmentStatusResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreatmentStatusResponse> update(@PathVariable UUID id, @RequestBody UpdateTreatmentStatusWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
