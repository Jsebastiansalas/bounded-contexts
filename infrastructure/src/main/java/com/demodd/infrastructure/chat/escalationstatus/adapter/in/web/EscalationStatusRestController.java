package com.demodd.infrastructure.chat.escalationstatus.adapter.in.web;

import com.demodd.application.chat.escalationstatus.dto.EscalationStatusResponse;
import com.demodd.application.chat.escalationstatus.port.in.CreateEscalationStatusUseCase;
import com.demodd.application.chat.escalationstatus.port.in.DeleteEscalationStatusUseCase;
import com.demodd.application.chat.escalationstatus.port.in.GetEscalationStatusUseCase;
import com.demodd.application.chat.escalationstatus.port.in.UpdateEscalationStatusUseCase;
import com.demodd.application.chat.escalationstatus.service.EscalationStatusApplicationService;
import com.demodd.domain.chat.escalationstatus.port.repository.EscalationStatusRepositoryPort;
import com.demodd.infrastructure.chat.escalationstatus.adapter.in.web.dto.CreateEscalationStatusWebRequest;
import com.demodd.infrastructure.chat.escalationstatus.adapter.in.web.dto.UpdateEscalationStatusWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat/escalationstatus")
public class EscalationStatusRestController {

    private final CreateEscalationStatusUseCase createUseCase;
    private final UpdateEscalationStatusUseCase updateUseCase;
    private final GetEscalationStatusUseCase getUseCase;
    private final DeleteEscalationStatusUseCase deleteUseCase;

    public EscalationStatusRestController(EscalationStatusRepositoryPort repository) {
        EscalationStatusApplicationService service = new EscalationStatusApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<EscalationStatusResponse> create(@RequestBody CreateEscalationStatusWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EscalationStatusResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EscalationStatusResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EscalationStatusResponse> update(@PathVariable UUID id, @RequestBody UpdateEscalationStatusWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
