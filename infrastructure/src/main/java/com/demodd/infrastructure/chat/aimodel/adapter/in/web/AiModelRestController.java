package com.demodd.infrastructure.chat.aimodel.adapter.in.web;

import com.demodd.application.chat.aimodel.dto.AiModelResponse;
import com.demodd.application.chat.aimodel.port.in.CreateAiModelUseCase;
import com.demodd.application.chat.aimodel.port.in.DeleteAiModelUseCase;
import com.demodd.application.chat.aimodel.port.in.GetAiModelUseCase;
import com.demodd.application.chat.aimodel.port.in.UpdateAiModelUseCase;
import com.demodd.application.chat.aimodel.service.AiModelApplicationService;
import com.demodd.domain.chat.aimodel.port.repository.AiModelRepositoryPort;
import com.demodd.infrastructure.chat.aimodel.adapter.in.web.dto.CreateAiModelWebRequest;
import com.demodd.infrastructure.chat.aimodel.adapter.in.web.dto.UpdateAiModelWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat/aimodel")
public class AiModelRestController {

    private final CreateAiModelUseCase createUseCase;
    private final UpdateAiModelUseCase updateUseCase;
    private final GetAiModelUseCase getUseCase;
    private final DeleteAiModelUseCase deleteUseCase;

    public AiModelRestController(AiModelRepositoryPort repository) {
        AiModelApplicationService service = new AiModelApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<AiModelResponse> create(@RequestBody CreateAiModelWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AiModelResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<AiModelResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AiModelResponse> update(@PathVariable UUID id, @RequestBody UpdateAiModelWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
