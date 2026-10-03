package com.demodd.infrastructure.patient.professional.adapter.in.web;

import com.demodd.application.patient.professional.dto.ProfessionalResponse;
import com.demodd.application.patient.professional.port.in.CreateProfessionalUseCase;
import com.demodd.application.patient.professional.port.in.DeleteProfessionalUseCase;
import com.demodd.application.patient.professional.port.in.GetProfessionalUseCase;
import com.demodd.application.patient.professional.port.in.UpdateProfessionalUseCase;
import com.demodd.application.patient.professional.service.ProfessionalApplicationService;
import com.demodd.domain.patient.professional.port.repository.ProfessionalRepositoryPort;
import com.demodd.infrastructure.patient.professional.adapter.in.web.dto.CreateProfessionalWebRequest;
import com.demodd.infrastructure.patient.professional.adapter.in.web.dto.UpdateProfessionalWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/patient/professional")
public class ProfessionalRestController {

    private final CreateProfessionalUseCase createUseCase;
    private final UpdateProfessionalUseCase updateUseCase;
    private final GetProfessionalUseCase getUseCase;
    private final DeleteProfessionalUseCase deleteUseCase;

    public ProfessionalRestController(ProfessionalRepositoryPort repository) {
        ProfessionalApplicationService service = new ProfessionalApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ProfessionalResponse> create(@RequestBody CreateProfessionalWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProfessionalResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessionalResponse> update(@PathVariable UUID id, @RequestBody UpdateProfessionalWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
