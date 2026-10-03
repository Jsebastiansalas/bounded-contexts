package com.demodd.infrastructure.clinical.encounter.adapter.in.web;

import com.demodd.application.clinical.encounter.dto.EncounterResponse;
import com.demodd.application.clinical.encounter.port.in.CreateEncounterUseCase;
import com.demodd.application.clinical.encounter.port.in.DeleteEncounterUseCase;
import com.demodd.application.clinical.encounter.port.in.GetEncounterUseCase;
import com.demodd.application.clinical.encounter.port.in.UpdateEncounterUseCase;
import com.demodd.application.clinical.encounter.service.EncounterApplicationService;
import com.demodd.domain.clinical.encounter.port.repository.EncounterRepositoryPort;
import com.demodd.infrastructure.clinical.encounter.adapter.in.web.dto.CreateEncounterWebRequest;
import com.demodd.infrastructure.clinical.encounter.adapter.in.web.dto.UpdateEncounterWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinical/encounter")
public class EncounterRestController {

    private final CreateEncounterUseCase createUseCase;
    private final UpdateEncounterUseCase updateUseCase;
    private final GetEncounterUseCase getUseCase;
    private final DeleteEncounterUseCase deleteUseCase;

    public EncounterRestController(EncounterRepositoryPort repository) {
        EncounterApplicationService service = new EncounterApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<EncounterResponse> create(@RequestBody CreateEncounterWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncounterResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EncounterResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EncounterResponse> update(@PathVariable UUID id, @RequestBody UpdateEncounterWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
