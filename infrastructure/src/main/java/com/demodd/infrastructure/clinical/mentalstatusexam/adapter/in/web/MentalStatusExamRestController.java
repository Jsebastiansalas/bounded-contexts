package com.demodd.infrastructure.clinical.mentalstatusexam.adapter.in.web;

import com.demodd.application.clinical.mentalstatusexam.dto.MentalStatusExamResponse;
import com.demodd.application.clinical.mentalstatusexam.port.in.CreateMentalStatusExamUseCase;
import com.demodd.application.clinical.mentalstatusexam.port.in.DeleteMentalStatusExamUseCase;
import com.demodd.application.clinical.mentalstatusexam.port.in.GetMentalStatusExamUseCase;
import com.demodd.application.clinical.mentalstatusexam.port.in.UpdateMentalStatusExamUseCase;
import com.demodd.application.clinical.mentalstatusexam.service.MentalStatusExamApplicationService;
import com.demodd.domain.clinical.mentalstatusexam.port.repository.MentalStatusExamRepositoryPort;
import com.demodd.infrastructure.clinical.mentalstatusexam.adapter.in.web.dto.CreateMentalStatusExamWebRequest;
import com.demodd.infrastructure.clinical.mentalstatusexam.adapter.in.web.dto.UpdateMentalStatusExamWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinical/mentalstatusexam")
public class MentalStatusExamRestController {

    private final CreateMentalStatusExamUseCase createUseCase;
    private final UpdateMentalStatusExamUseCase updateUseCase;
    private final GetMentalStatusExamUseCase getUseCase;
    private final DeleteMentalStatusExamUseCase deleteUseCase;

    public MentalStatusExamRestController(MentalStatusExamRepositoryPort repository) {
        MentalStatusExamApplicationService service = new MentalStatusExamApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<MentalStatusExamResponse> create(@RequestBody CreateMentalStatusExamWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MentalStatusExamResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<MentalStatusExamResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MentalStatusExamResponse> update(@PathVariable UUID id, @RequestBody UpdateMentalStatusExamWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
