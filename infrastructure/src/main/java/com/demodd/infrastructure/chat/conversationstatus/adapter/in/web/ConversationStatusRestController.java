package com.demodd.infrastructure.chat.conversationstatus.adapter.in.web;

import com.demodd.application.chat.conversationstatus.dto.ConversationStatusResponse;
import com.demodd.application.chat.conversationstatus.port.in.CreateConversationStatusUseCase;
import com.demodd.application.chat.conversationstatus.port.in.DeleteConversationStatusUseCase;
import com.demodd.application.chat.conversationstatus.port.in.GetConversationStatusUseCase;
import com.demodd.application.chat.conversationstatus.port.in.UpdateConversationStatusUseCase;
import com.demodd.application.chat.conversationstatus.service.ConversationStatusApplicationService;
import com.demodd.domain.chat.conversationstatus.port.repository.ConversationStatusRepositoryPort;
import com.demodd.infrastructure.chat.conversationstatus.adapter.in.web.dto.CreateConversationStatusWebRequest;
import com.demodd.infrastructure.chat.conversationstatus.adapter.in.web.dto.UpdateConversationStatusWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat/conversationstatus")
public class ConversationStatusRestController {

    private final CreateConversationStatusUseCase createUseCase;
    private final UpdateConversationStatusUseCase updateUseCase;
    private final GetConversationStatusUseCase getUseCase;
    private final DeleteConversationStatusUseCase deleteUseCase;

    public ConversationStatusRestController(ConversationStatusRepositoryPort repository) {
        ConversationStatusApplicationService service = new ConversationStatusApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ConversationStatusResponse> create(@RequestBody CreateConversationStatusWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConversationStatusResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ConversationStatusResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConversationStatusResponse> update(@PathVariable UUID id, @RequestBody UpdateConversationStatusWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
