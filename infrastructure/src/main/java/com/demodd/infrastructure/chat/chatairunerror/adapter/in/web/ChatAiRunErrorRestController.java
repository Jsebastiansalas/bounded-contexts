package com.demodd.infrastructure.chat.chatairunerror.adapter.in.web;

import com.demodd.application.chat.chatairunerror.dto.ChatAiRunErrorResponse;
import com.demodd.application.chat.chatairunerror.port.in.CreateChatAiRunErrorUseCase;
import com.demodd.application.chat.chatairunerror.port.in.DeleteChatAiRunErrorUseCase;
import com.demodd.application.chat.chatairunerror.port.in.GetChatAiRunErrorUseCase;
import com.demodd.application.chat.chatairunerror.port.in.UpdateChatAiRunErrorUseCase;
import com.demodd.application.chat.chatairunerror.service.ChatAiRunErrorApplicationService;
import com.demodd.domain.chat.chatairunerror.port.repository.ChatAiRunErrorRepositoryPort;
import com.demodd.infrastructure.chat.chatairunerror.adapter.in.web.dto.CreateChatAiRunErrorWebRequest;
import com.demodd.infrastructure.chat.chatairunerror.adapter.in.web.dto.UpdateChatAiRunErrorWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat/chatairunerror")
public class ChatAiRunErrorRestController {

    private final CreateChatAiRunErrorUseCase createUseCase;
    private final UpdateChatAiRunErrorUseCase updateUseCase;
    private final GetChatAiRunErrorUseCase getUseCase;
    private final DeleteChatAiRunErrorUseCase deleteUseCase;

    public ChatAiRunErrorRestController(ChatAiRunErrorRepositoryPort repository) {
        ChatAiRunErrorApplicationService service = new ChatAiRunErrorApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ChatAiRunErrorResponse> create(@RequestBody CreateChatAiRunErrorWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatAiRunErrorResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ChatAiRunErrorResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatAiRunErrorResponse> update(@PathVariable UUID id, @RequestBody UpdateChatAiRunErrorWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
