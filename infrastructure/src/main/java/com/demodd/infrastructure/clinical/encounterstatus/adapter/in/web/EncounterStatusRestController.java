package com.demodd.infrastructure.clinical.encounterstatus.adapter.in.web;

import com.demodd.application.clinical.encounterstatus.dto.EncounterStatusResponse;
import com.demodd.application.clinical.encounterstatus.port.in.CreateEncounterStatusUseCase;
import com.demodd.application.clinical.encounterstatus.port.in.DeleteEncounterStatusUseCase;
import com.demodd.application.clinical.encounterstatus.port.in.GetEncounterStatusUseCase;
import com.demodd.application.clinical.encounterstatus.port.in.UpdateEncounterStatusUseCase;
import com.demodd.application.clinical.encounterstatus.service.EncounterStatusApplicationService;
import com.demodd.domain.clinical.encounterstatus.port.repository.EncounterStatusRepositoryPort;
import com.demodd.infrastructure.clinical.encounterstatus.adapter.in.web.dto.CreateEncounterStatusWebRequest;
import com.demodd.infrastructure.clinical.encounterstatus.adapter.in.web.dto.UpdateEncounterStatusWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinical/encounterstatus")
public class EncounterStatusRestController {

    private final CreateEncounterStatusUseCase createUseCase;
    private final UpdateEncounterStatusUseCase updateUseCase;
    private final GetEncounterStatusUseCase getUseCase;
    private final DeleteEncounterStatusUseCase deleteUseCase;

    public EncounterStatusRestController(EncounterStatusRepositoryPort repository) {
        EncounterStatusApplicationService service = new EncounterStatusApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<EncounterStatusResponse> create(@RequestBody CreateEncounterStatusWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncounterStatusResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EncounterStatusResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EncounterStatusResponse> update(@PathVariable UUID id, @RequestBody UpdateEncounterStatusWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
