package com.demodd.infrastructure.clinical.consenttype.adapter.in.web;

import com.demodd.application.clinical.consenttype.dto.ConsentTypeResponse;
import com.demodd.application.clinical.consenttype.port.in.CreateConsentTypeUseCase;
import com.demodd.application.clinical.consenttype.port.in.DeleteConsentTypeUseCase;
import com.demodd.application.clinical.consenttype.port.in.GetConsentTypeUseCase;
import com.demodd.application.clinical.consenttype.port.in.UpdateConsentTypeUseCase;
import com.demodd.application.clinical.consenttype.service.ConsentTypeApplicationService;
import com.demodd.domain.clinical.consenttype.port.repository.ConsentTypeRepositoryPort;
import com.demodd.infrastructure.clinical.consenttype.adapter.in.web.dto.CreateConsentTypeWebRequest;
import com.demodd.infrastructure.clinical.consenttype.adapter.in.web.dto.UpdateConsentTypeWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinical/consenttype")
public class ConsentTypeRestController {

    private final CreateConsentTypeUseCase createUseCase;
    private final UpdateConsentTypeUseCase updateUseCase;
    private final GetConsentTypeUseCase getUseCase;
    private final DeleteConsentTypeUseCase deleteUseCase;

    public ConsentTypeRestController(ConsentTypeRepositoryPort repository) {
        ConsentTypeApplicationService service = new ConsentTypeApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ConsentTypeResponse> create(@RequestBody CreateConsentTypeWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsentTypeResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ConsentTypeResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsentTypeResponse> update(@PathVariable UUID id, @RequestBody UpdateConsentTypeWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
