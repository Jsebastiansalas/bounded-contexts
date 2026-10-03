package com.demodd.infrastructure.clinical.encountermodality.adapter.in.web;

import com.demodd.application.clinical.encountermodality.dto.EncounterModalityResponse;
import com.demodd.application.clinical.encountermodality.port.in.CreateEncounterModalityUseCase;
import com.demodd.application.clinical.encountermodality.port.in.DeleteEncounterModalityUseCase;
import com.demodd.application.clinical.encountermodality.port.in.GetEncounterModalityUseCase;
import com.demodd.application.clinical.encountermodality.port.in.UpdateEncounterModalityUseCase;
import com.demodd.application.clinical.encountermodality.service.EncounterModalityApplicationService;
import com.demodd.domain.clinical.encountermodality.port.repository.EncounterModalityRepositoryPort;
import com.demodd.infrastructure.clinical.encountermodality.adapter.in.web.dto.CreateEncounterModalityWebRequest;
import com.demodd.infrastructure.clinical.encountermodality.adapter.in.web.dto.UpdateEncounterModalityWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinical/encountermodality")
public class EncounterModalityRestController {

    private final CreateEncounterModalityUseCase createUseCase;
    private final UpdateEncounterModalityUseCase updateUseCase;
    private final GetEncounterModalityUseCase getUseCase;
    private final DeleteEncounterModalityUseCase deleteUseCase;

    public EncounterModalityRestController(EncounterModalityRepositoryPort repository) {
        EncounterModalityApplicationService service = new EncounterModalityApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<EncounterModalityResponse> create(@RequestBody CreateEncounterModalityWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncounterModalityResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EncounterModalityResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EncounterModalityResponse> update(@PathVariable UUID id, @RequestBody UpdateEncounterModalityWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
