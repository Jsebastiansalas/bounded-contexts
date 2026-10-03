package com.demodd.infrastructure.geography.professionaltype.adapter.in.web;

import com.demodd.application.geography.professionaltype.dto.ProfessionalTypeResponse;
import com.demodd.application.geography.professionaltype.port.in.CreateProfessionalTypeUseCase;
import com.demodd.application.geography.professionaltype.port.in.DeleteProfessionalTypeUseCase;
import com.demodd.application.geography.professionaltype.port.in.GetProfessionalTypeUseCase;
import com.demodd.application.geography.professionaltype.port.in.UpdateProfessionalTypeUseCase;
import com.demodd.application.geography.professionaltype.service.ProfessionalTypeApplicationService;
import com.demodd.domain.geography.professionaltype.port.repository.ProfessionalTypeRepositoryPort;
import com.demodd.infrastructure.geography.professionaltype.adapter.in.web.dto.CreateProfessionalTypeWebRequest;
import com.demodd.infrastructure.geography.professionaltype.adapter.in.web.dto.UpdateProfessionalTypeWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/geography/professionaltype")
public class ProfessionalTypeRestController {

    private final CreateProfessionalTypeUseCase createUseCase;
    private final UpdateProfessionalTypeUseCase updateUseCase;
    private final GetProfessionalTypeUseCase getUseCase;
    private final DeleteProfessionalTypeUseCase deleteUseCase;

    public ProfessionalTypeRestController(ProfessionalTypeRepositoryPort repository) {
        ProfessionalTypeApplicationService service = new ProfessionalTypeApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ProfessionalTypeResponse> create(@RequestBody CreateProfessionalTypeWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalTypeResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProfessionalTypeResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessionalTypeResponse> update(@PathVariable UUID id, @RequestBody UpdateProfessionalTypeWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
