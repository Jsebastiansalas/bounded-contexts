package com.demodd.infrastructure.clinical.treatmentplan.adapter.in.web;

import com.demodd.application.clinical.treatmentplan.dto.TreatmentPlanResponse;
import com.demodd.application.clinical.treatmentplan.port.in.CreateTreatmentPlanUseCase;
import com.demodd.application.clinical.treatmentplan.port.in.DeleteTreatmentPlanUseCase;
import com.demodd.application.clinical.treatmentplan.port.in.GetTreatmentPlanUseCase;
import com.demodd.application.clinical.treatmentplan.port.in.UpdateTreatmentPlanUseCase;
import com.demodd.application.clinical.treatmentplan.service.TreatmentPlanApplicationService;
import com.demodd.domain.clinical.treatmentplan.port.repository.TreatmentPlanRepositoryPort;
import com.demodd.infrastructure.clinical.treatmentplan.adapter.in.web.dto.CreateTreatmentPlanWebRequest;
import com.demodd.infrastructure.clinical.treatmentplan.adapter.in.web.dto.UpdateTreatmentPlanWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinical/treatmentplan")
public class TreatmentPlanRestController {

    private final CreateTreatmentPlanUseCase createUseCase;
    private final UpdateTreatmentPlanUseCase updateUseCase;
    private final GetTreatmentPlanUseCase getUseCase;
    private final DeleteTreatmentPlanUseCase deleteUseCase;

    public TreatmentPlanRestController(TreatmentPlanRepositoryPort repository) {
        TreatmentPlanApplicationService service = new TreatmentPlanApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<TreatmentPlanResponse> create(@RequestBody CreateTreatmentPlanWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreatmentPlanResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<TreatmentPlanResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreatmentPlanResponse> update(@PathVariable UUID id, @RequestBody UpdateTreatmentPlanWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
