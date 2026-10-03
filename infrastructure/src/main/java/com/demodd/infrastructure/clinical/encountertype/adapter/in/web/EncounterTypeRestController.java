package com.demodd.infrastructure.clinical.encountertype.adapter.in.web;

import com.demodd.application.clinical.encountertype.dto.EncounterTypeResponse;
import com.demodd.application.clinical.encountertype.port.in.CreateEncounterTypeUseCase;
import com.demodd.application.clinical.encountertype.port.in.DeleteEncounterTypeUseCase;
import com.demodd.application.clinical.encountertype.port.in.GetEncounterTypeUseCase;
import com.demodd.application.clinical.encountertype.port.in.UpdateEncounterTypeUseCase;
import com.demodd.application.clinical.encountertype.service.EncounterTypeApplicationService;
import com.demodd.domain.clinical.encountertype.port.repository.EncounterTypeRepositoryPort;
import com.demodd.infrastructure.clinical.encountertype.adapter.in.web.dto.CreateEncounterTypeWebRequest;
import com.demodd.infrastructure.clinical.encountertype.adapter.in.web.dto.UpdateEncounterTypeWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinical/encountertype")
public class EncounterTypeRestController {

    private final CreateEncounterTypeUseCase createUseCase;
    private final UpdateEncounterTypeUseCase updateUseCase;
    private final GetEncounterTypeUseCase getUseCase;
    private final DeleteEncounterTypeUseCase deleteUseCase;

    public EncounterTypeRestController(EncounterTypeRepositoryPort repository) {
        EncounterTypeApplicationService service = new EncounterTypeApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<EncounterTypeResponse> create(@RequestBody CreateEncounterTypeWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncounterTypeResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EncounterTypeResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EncounterTypeResponse> update(@PathVariable UUID id, @RequestBody UpdateEncounterTypeWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
