package com.demodd.infrastructure.chat.chatairunmetric.adapter.in.web;

import com.demodd.application.chat.chatairunmetric.dto.ChatAiRunMetricResponse;
import com.demodd.application.chat.chatairunmetric.port.in.CreateChatAiRunMetricUseCase;
import com.demodd.application.chat.chatairunmetric.port.in.DeleteChatAiRunMetricUseCase;
import com.demodd.application.chat.chatairunmetric.port.in.GetChatAiRunMetricUseCase;
import com.demodd.application.chat.chatairunmetric.port.in.UpdateChatAiRunMetricUseCase;
import com.demodd.application.chat.chatairunmetric.service.ChatAiRunMetricApplicationService;
import com.demodd.domain.chat.chatairunmetric.port.repository.ChatAiRunMetricRepositoryPort;
import com.demodd.infrastructure.chat.chatairunmetric.adapter.in.web.dto.CreateChatAiRunMetricWebRequest;
import com.demodd.infrastructure.chat.chatairunmetric.adapter.in.web.dto.UpdateChatAiRunMetricWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat/chatairunmetric")
public class ChatAiRunMetricRestController {

    private final CreateChatAiRunMetricUseCase createUseCase;
    private final UpdateChatAiRunMetricUseCase updateUseCase;
    private final GetChatAiRunMetricUseCase getUseCase;
    private final DeleteChatAiRunMetricUseCase deleteUseCase;

    public ChatAiRunMetricRestController(ChatAiRunMetricRepositoryPort repository) {
        ChatAiRunMetricApplicationService service = new ChatAiRunMetricApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ChatAiRunMetricResponse> create(@RequestBody CreateChatAiRunMetricWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatAiRunMetricResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ChatAiRunMetricResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatAiRunMetricResponse> update(@PathVariable UUID id, @RequestBody UpdateChatAiRunMetricWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
