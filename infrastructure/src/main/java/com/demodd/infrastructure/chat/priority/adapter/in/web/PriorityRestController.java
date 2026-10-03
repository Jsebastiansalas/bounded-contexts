package com.demodd.infrastructure.chat.priority.adapter.in.web;

import com.demodd.application.chat.priority.dto.PriorityResponse;
import com.demodd.application.chat.priority.port.in.CreatePriorityUseCase;
import com.demodd.application.chat.priority.port.in.DeletePriorityUseCase;
import com.demodd.application.chat.priority.port.in.GetPriorityUseCase;
import com.demodd.application.chat.priority.port.in.UpdatePriorityUseCase;
import com.demodd.application.chat.priority.service.PriorityApplicationService;
import com.demodd.domain.chat.priority.port.repository.PriorityRepositoryPort;
import com.demodd.infrastructure.chat.priority.adapter.in.web.dto.CreatePriorityWebRequest;
import com.demodd.infrastructure.chat.priority.adapter.in.web.dto.UpdatePriorityWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat/priority")
public class PriorityRestController {

    private final CreatePriorityUseCase createUseCase;
    private final UpdatePriorityUseCase updateUseCase;
    private final GetPriorityUseCase getUseCase;
    private final DeletePriorityUseCase deleteUseCase;

    public PriorityRestController(PriorityRepositoryPort repository) {
        PriorityApplicationService service = new PriorityApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<PriorityResponse> create(@RequestBody CreatePriorityWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriorityResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PriorityResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PriorityResponse> update(@PathVariable UUID id, @RequestBody UpdatePriorityWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
