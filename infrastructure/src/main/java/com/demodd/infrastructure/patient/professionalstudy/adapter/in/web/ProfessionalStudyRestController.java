package com.demodd.infrastructure.patient.professionalstudy.adapter.in.web;

import com.demodd.application.patient.professionalstudy.dto.ProfessionalStudyResponse;
import com.demodd.application.patient.professionalstudy.port.in.CreateProfessionalStudyUseCase;
import com.demodd.application.patient.professionalstudy.port.in.DeleteProfessionalStudyUseCase;
import com.demodd.application.patient.professionalstudy.port.in.GetProfessionalStudyUseCase;
import com.demodd.application.patient.professionalstudy.port.in.UpdateProfessionalStudyUseCase;
import com.demodd.application.patient.professionalstudy.service.ProfessionalStudyApplicationService;
import com.demodd.domain.patient.professionalstudy.port.repository.ProfessionalStudyRepositoryPort;
import com.demodd.infrastructure.patient.professionalstudy.adapter.in.web.dto.CreateProfessionalStudyWebRequest;
import com.demodd.infrastructure.patient.professionalstudy.adapter.in.web.dto.UpdateProfessionalStudyWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/patient/professionalstudy")
public class ProfessionalStudyRestController {

    private final CreateProfessionalStudyUseCase createUseCase;
    private final UpdateProfessionalStudyUseCase updateUseCase;
    private final GetProfessionalStudyUseCase getUseCase;
    private final DeleteProfessionalStudyUseCase deleteUseCase;

    public ProfessionalStudyRestController(ProfessionalStudyRepositoryPort repository) {
        ProfessionalStudyApplicationService service = new ProfessionalStudyApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ProfessionalStudyResponse> create(@RequestBody CreateProfessionalStudyWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalStudyResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProfessionalStudyResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessionalStudyResponse> update(@PathVariable UUID id, @RequestBody UpdateProfessionalStudyWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
