package com.demodd.infrastructure.chat.providermodelai.adapter.in.web;

import com.demodd.application.chat.providermodelai.dto.ProviderModelAiResponse;
import com.demodd.application.chat.providermodelai.port.in.CreateProviderModelAiUseCase;
import com.demodd.application.chat.providermodelai.port.in.DeleteProviderModelAiUseCase;
import com.demodd.application.chat.providermodelai.port.in.GetProviderModelAiUseCase;
import com.demodd.application.chat.providermodelai.port.in.UpdateProviderModelAiUseCase;
import com.demodd.application.chat.providermodelai.service.ProviderModelAiApplicationService;
import com.demodd.domain.chat.providermodelai.port.repository.ProviderModelAiRepositoryPort;
import com.demodd.infrastructure.chat.providermodelai.adapter.in.web.dto.CreateProviderModelAiWebRequest;
import com.demodd.infrastructure.chat.providermodelai.adapter.in.web.dto.UpdateProviderModelAiWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat/providermodelai")
public class ProviderModelAiRestController {

    private final CreateProviderModelAiUseCase createUseCase;
    private final UpdateProviderModelAiUseCase updateUseCase;
    private final GetProviderModelAiUseCase getUseCase;
    private final DeleteProviderModelAiUseCase deleteUseCase;

    public ProviderModelAiRestController(ProviderModelAiRepositoryPort repository) {
        ProviderModelAiApplicationService service = new ProviderModelAiApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ProviderModelAiResponse> create(@RequestBody CreateProviderModelAiWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderModelAiResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProviderModelAiResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProviderModelAiResponse> update(@PathVariable UUID id, @RequestBody UpdateProviderModelAiWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
