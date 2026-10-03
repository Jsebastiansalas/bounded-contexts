package com.demodd.infrastructure.clinical.treatmentgoal.adapter.in.web;

import com.demodd.application.clinical.treatmentgoal.dto.TreatmentGoalResponse;
import com.demodd.application.clinical.treatmentgoal.port.in.CreateTreatmentGoalUseCase;
import com.demodd.application.clinical.treatmentgoal.port.in.DeleteTreatmentGoalUseCase;
import com.demodd.application.clinical.treatmentgoal.port.in.GetTreatmentGoalUseCase;
import com.demodd.application.clinical.treatmentgoal.port.in.UpdateTreatmentGoalUseCase;
import com.demodd.application.clinical.treatmentgoal.service.TreatmentGoalApplicationService;
import com.demodd.domain.clinical.treatmentgoal.port.repository.TreatmentGoalRepositoryPort;
import com.demodd.infrastructure.clinical.treatmentgoal.adapter.in.web.dto.CreateTreatmentGoalWebRequest;
import com.demodd.infrastructure.clinical.treatmentgoal.adapter.in.web.dto.UpdateTreatmentGoalWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinical/treatmentgoal")
public class TreatmentGoalRestController {

    private final CreateTreatmentGoalUseCase createUseCase;
    private final UpdateTreatmentGoalUseCase updateUseCase;
    private final GetTreatmentGoalUseCase getUseCase;
    private final DeleteTreatmentGoalUseCase deleteUseCase;

    public TreatmentGoalRestController(TreatmentGoalRepositoryPort repository) {
        TreatmentGoalApplicationService service = new TreatmentGoalApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<TreatmentGoalResponse> create(@RequestBody CreateTreatmentGoalWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreatmentGoalResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<TreatmentGoalResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreatmentGoalResponse> update(@PathVariable UUID id, @RequestBody UpdateTreatmentGoalWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
