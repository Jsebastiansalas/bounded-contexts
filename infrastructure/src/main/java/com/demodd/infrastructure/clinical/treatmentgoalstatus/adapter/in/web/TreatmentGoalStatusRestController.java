package com.demodd.infrastructure.clinical.treatmentgoalstatus.adapter.in.web;

import com.demodd.application.clinical.treatmentgoalstatus.dto.TreatmentGoalStatusResponse;
import com.demodd.application.clinical.treatmentgoalstatus.port.in.CreateTreatmentGoalStatusUseCase;
import com.demodd.application.clinical.treatmentgoalstatus.port.in.DeleteTreatmentGoalStatusUseCase;
import com.demodd.application.clinical.treatmentgoalstatus.port.in.GetTreatmentGoalStatusUseCase;
import com.demodd.application.clinical.treatmentgoalstatus.port.in.UpdateTreatmentGoalStatusUseCase;
import com.demodd.application.clinical.treatmentgoalstatus.service.TreatmentGoalStatusApplicationService;
import com.demodd.domain.clinical.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepositoryPort;
import com.demodd.infrastructure.clinical.treatmentgoalstatus.adapter.in.web.dto.CreateTreatmentGoalStatusWebRequest;
import com.demodd.infrastructure.clinical.treatmentgoalstatus.adapter.in.web.dto.UpdateTreatmentGoalStatusWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinical/treatmentgoalstatus")
public class TreatmentGoalStatusRestController {

    private final CreateTreatmentGoalStatusUseCase createUseCase;
    private final UpdateTreatmentGoalStatusUseCase updateUseCase;
    private final GetTreatmentGoalStatusUseCase getUseCase;
    private final DeleteTreatmentGoalStatusUseCase deleteUseCase;

    public TreatmentGoalStatusRestController(TreatmentGoalStatusRepositoryPort repository) {
        TreatmentGoalStatusApplicationService service = new TreatmentGoalStatusApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<TreatmentGoalStatusResponse> create(@RequestBody CreateTreatmentGoalStatusWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreatmentGoalStatusResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<TreatmentGoalStatusResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreatmentGoalStatusResponse> update(@PathVariable UUID id, @RequestBody UpdateTreatmentGoalStatusWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
