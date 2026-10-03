package com.demodd.infrastructure.geography.study.adapter.in.web;

import com.demodd.application.geography.study.dto.StudyResponse;
import com.demodd.application.geography.study.port.in.CreateStudyUseCase;
import com.demodd.application.geography.study.port.in.DeleteStudyUseCase;
import com.demodd.application.geography.study.port.in.GetStudyUseCase;
import com.demodd.application.geography.study.port.in.UpdateStudyUseCase;
import com.demodd.application.geography.study.service.StudyApplicationService;
import com.demodd.domain.geography.study.port.repository.StudyRepositoryPort;
import com.demodd.infrastructure.geography.study.adapter.in.web.dto.CreateStudyWebRequest;
import com.demodd.infrastructure.geography.study.adapter.in.web.dto.UpdateStudyWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/geography/study")
public class StudyRestController {

    private final CreateStudyUseCase createUseCase;
    private final UpdateStudyUseCase updateUseCase;
    private final GetStudyUseCase getUseCase;
    private final DeleteStudyUseCase deleteUseCase;

    public StudyRestController(StudyRepositoryPort repository) {
        StudyApplicationService service = new StudyApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<StudyResponse> create(@RequestBody CreateStudyWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudyResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudyResponse> update(@PathVariable UUID id, @RequestBody UpdateStudyWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
