package com.demodd.infrastructure.clinical.assessmenttype.adapter.in.web;

import com.demodd.application.clinical.assessmenttype.dto.AssessmentTypeResponse;
import com.demodd.application.clinical.assessmenttype.port.in.CreateAssessmentTypeUseCase;
import com.demodd.application.clinical.assessmenttype.port.in.DeleteAssessmentTypeUseCase;
import com.demodd.application.clinical.assessmenttype.port.in.GetAssessmentTypeUseCase;
import com.demodd.application.clinical.assessmenttype.port.in.UpdateAssessmentTypeUseCase;
import com.demodd.application.clinical.assessmenttype.service.AssessmentTypeApplicationService;
import com.demodd.domain.clinical.assessmenttype.port.repository.AssessmentTypeRepositoryPort;
import com.demodd.infrastructure.clinical.assessmenttype.adapter.in.web.dto.CreateAssessmentTypeWebRequest;
import com.demodd.infrastructure.clinical.assessmenttype.adapter.in.web.dto.UpdateAssessmentTypeWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinical/assessmenttype")
public class AssessmentTypeRestController {

    private final CreateAssessmentTypeUseCase createUseCase;
    private final UpdateAssessmentTypeUseCase updateUseCase;
    private final GetAssessmentTypeUseCase getUseCase;
    private final DeleteAssessmentTypeUseCase deleteUseCase;

    public AssessmentTypeRestController(AssessmentTypeRepositoryPort repository) {
        AssessmentTypeApplicationService service = new AssessmentTypeApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<AssessmentTypeResponse> create(@RequestBody CreateAssessmentTypeWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssessmentTypeResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<AssessmentTypeResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssessmentTypeResponse> update(@PathVariable UUID id, @RequestBody UpdateAssessmentTypeWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
