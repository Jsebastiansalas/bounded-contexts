package com.demodd.infrastructure.clinical.risklevel.adapter.in.web;

import com.demodd.application.clinical.risklevel.dto.RiskLevelResponse;
import com.demodd.application.clinical.risklevel.port.in.CreateRiskLevelUseCase;
import com.demodd.application.clinical.risklevel.port.in.DeleteRiskLevelUseCase;
import com.demodd.application.clinical.risklevel.port.in.GetRiskLevelUseCase;
import com.demodd.application.clinical.risklevel.port.in.UpdateRiskLevelUseCase;
import com.demodd.application.clinical.risklevel.service.RiskLevelApplicationService;
import com.demodd.domain.clinical.risklevel.port.repository.RiskLevelRepositoryPort;
import com.demodd.infrastructure.clinical.risklevel.adapter.in.web.dto.CreateRiskLevelWebRequest;
import com.demodd.infrastructure.clinical.risklevel.adapter.in.web.dto.UpdateRiskLevelWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinical/risklevel")
public class RiskLevelRestController {

    private final CreateRiskLevelUseCase createUseCase;
    private final UpdateRiskLevelUseCase updateUseCase;
    private final GetRiskLevelUseCase getUseCase;
    private final DeleteRiskLevelUseCase deleteUseCase;

    public RiskLevelRestController(RiskLevelRepositoryPort repository) {
        RiskLevelApplicationService service = new RiskLevelApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<RiskLevelResponse> create(@RequestBody CreateRiskLevelWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskLevelResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<RiskLevelResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskLevelResponse> update(@PathVariable UUID id, @RequestBody UpdateRiskLevelWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
