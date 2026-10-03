package com.demodd.infrastructure.chat.chatairun.adapter.in.web;

import com.demodd.application.chat.chatairun.dto.ChatAiRunResponse;
import com.demodd.application.chat.chatairun.port.in.CreateChatAiRunUseCase;
import com.demodd.application.chat.chatairun.port.in.DeleteChatAiRunUseCase;
import com.demodd.application.chat.chatairun.port.in.GetChatAiRunUseCase;
import com.demodd.application.chat.chatairun.port.in.UpdateChatAiRunUseCase;
import com.demodd.application.chat.chatairun.service.ChatAiRunApplicationService;
import com.demodd.domain.chat.chatairun.port.repository.ChatAiRunRepositoryPort;
import com.demodd.infrastructure.chat.chatairun.adapter.in.web.dto.CreateChatAiRunWebRequest;
import com.demodd.infrastructure.chat.chatairun.adapter.in.web.dto.UpdateChatAiRunWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat/chatairun")
public class ChatAiRunRestController {

    private final CreateChatAiRunUseCase createUseCase;
    private final UpdateChatAiRunUseCase updateUseCase;
    private final GetChatAiRunUseCase getUseCase;
    private final DeleteChatAiRunUseCase deleteUseCase;

    public ChatAiRunRestController(ChatAiRunRepositoryPort repository) {
        ChatAiRunApplicationService service = new ChatAiRunApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ChatAiRunResponse> create(@RequestBody CreateChatAiRunWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatAiRunResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ChatAiRunResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatAiRunResponse> update(@PathVariable UUID id, @RequestBody UpdateChatAiRunWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
