package com.demodd.infrastructure.clinical.riskassessment.adapter.in.web;

import com.demodd.application.clinical.riskassessment.dto.RiskAssessmentResponse;
import com.demodd.application.clinical.riskassessment.port.in.CreateRiskAssessmentUseCase;
import com.demodd.application.clinical.riskassessment.port.in.DeleteRiskAssessmentUseCase;
import com.demodd.application.clinical.riskassessment.port.in.GetRiskAssessmentUseCase;
import com.demodd.application.clinical.riskassessment.port.in.UpdateRiskAssessmentUseCase;
import com.demodd.application.clinical.riskassessment.service.RiskAssessmentApplicationService;
import com.demodd.domain.clinical.riskassessment.port.repository.RiskAssessmentRepositoryPort;
import com.demodd.infrastructure.clinical.riskassessment.adapter.in.web.dto.CreateRiskAssessmentWebRequest;
import com.demodd.infrastructure.clinical.riskassessment.adapter.in.web.dto.UpdateRiskAssessmentWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinical/riskassessment")
public class RiskAssessmentRestController {

    private final CreateRiskAssessmentUseCase createUseCase;
    private final UpdateRiskAssessmentUseCase updateUseCase;
    private final GetRiskAssessmentUseCase getUseCase;
    private final DeleteRiskAssessmentUseCase deleteUseCase;

    public RiskAssessmentRestController(RiskAssessmentRepositoryPort repository) {
        RiskAssessmentApplicationService service = new RiskAssessmentApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<RiskAssessmentResponse> create(@RequestBody CreateRiskAssessmentWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskAssessmentResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<RiskAssessmentResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskAssessmentResponse> update(@PathVariable UUID id, @RequestBody UpdateRiskAssessmentWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
