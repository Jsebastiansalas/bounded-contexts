package com.demodd.infrastructure.chat.airunstatus.adapter.in.web;

import com.demodd.application.chat.airunstatus.dto.AiRunStatusResponse;
import com.demodd.application.chat.airunstatus.port.in.CreateAiRunStatusUseCase;
import com.demodd.application.chat.airunstatus.port.in.DeleteAiRunStatusUseCase;
import com.demodd.application.chat.airunstatus.port.in.GetAiRunStatusUseCase;
import com.demodd.application.chat.airunstatus.port.in.UpdateAiRunStatusUseCase;
import com.demodd.application.chat.airunstatus.service.AiRunStatusApplicationService;
import com.demodd.domain.chat.airunstatus.port.repository.AiRunStatusRepositoryPort;
import com.demodd.infrastructure.chat.airunstatus.adapter.in.web.dto.CreateAiRunStatusWebRequest;
import com.demodd.infrastructure.chat.airunstatus.adapter.in.web.dto.UpdateAiRunStatusWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat/airunstatus")
public class AiRunStatusRestController {

    private final CreateAiRunStatusUseCase createUseCase;
    private final UpdateAiRunStatusUseCase updateUseCase;
    private final GetAiRunStatusUseCase getUseCase;
    private final DeleteAiRunStatusUseCase deleteUseCase;

    public AiRunStatusRestController(AiRunStatusRepositoryPort repository) {
        AiRunStatusApplicationService service = new AiRunStatusApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<AiRunStatusResponse> create(@RequestBody CreateAiRunStatusWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AiRunStatusResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<AiRunStatusResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AiRunStatusResponse> update(@PathVariable UUID id, @RequestBody UpdateAiRunStatusWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
