package com.demodd.infrastructure.geography.stateregion.adapter.in.web;

import com.demodd.application.geography.stateregion.dto.StateRegionResponse;
import com.demodd.application.geography.stateregion.port.in.CreateStateRegionUseCase;
import com.demodd.application.geography.stateregion.port.in.DeleteStateRegionUseCase;
import com.demodd.application.geography.stateregion.port.in.GetStateRegionUseCase;
import com.demodd.application.geography.stateregion.port.in.UpdateStateRegionUseCase;
import com.demodd.application.geography.stateregion.service.StateRegionApplicationService;
import com.demodd.domain.geography.stateregion.port.repository.StateRegionRepositoryPort;
import com.demodd.infrastructure.geography.stateregion.adapter.in.web.dto.CreateStateRegionWebRequest;
import com.demodd.infrastructure.geography.stateregion.adapter.in.web.dto.UpdateStateRegionWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/geography/stateregion")
public class StateRegionRestController {

    private final CreateStateRegionUseCase createUseCase;
    private final UpdateStateRegionUseCase updateUseCase;
    private final GetStateRegionUseCase getUseCase;
    private final DeleteStateRegionUseCase deleteUseCase;

    public StateRegionRestController(StateRegionRepositoryPort repository) {
        StateRegionApplicationService service = new StateRegionApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<StateRegionResponse> create(@RequestBody CreateStateRegionWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateRegionResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<StateRegionResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StateRegionResponse> update(@PathVariable UUID id, @RequestBody UpdateStateRegionWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
