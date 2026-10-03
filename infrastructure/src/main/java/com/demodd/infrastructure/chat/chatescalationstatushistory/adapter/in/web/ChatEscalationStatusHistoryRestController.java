package com.demodd.infrastructure.chat.chatescalationstatushistory.adapter.in.web;

import com.demodd.application.chat.chatescalationstatushistory.dto.ChatEscalationStatusHistoryResponse;
import com.demodd.application.chat.chatescalationstatushistory.port.in.CreateChatEscalationStatusHistoryUseCase;
import com.demodd.application.chat.chatescalationstatushistory.port.in.DeleteChatEscalationStatusHistoryUseCase;
import com.demodd.application.chat.chatescalationstatushistory.port.in.GetChatEscalationStatusHistoryUseCase;
import com.demodd.application.chat.chatescalationstatushistory.port.in.UpdateChatEscalationStatusHistoryUseCase;
import com.demodd.application.chat.chatescalationstatushistory.service.ChatEscalationStatusHistoryApplicationService;
import com.demodd.domain.chat.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepositoryPort;
import com.demodd.infrastructure.chat.chatescalationstatushistory.adapter.in.web.dto.CreateChatEscalationStatusHistoryWebRequest;
import com.demodd.infrastructure.chat.chatescalationstatushistory.adapter.in.web.dto.UpdateChatEscalationStatusHistoryWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat/chatescalationstatushistory")
public class ChatEscalationStatusHistoryRestController {

    private final CreateChatEscalationStatusHistoryUseCase createUseCase;
    private final UpdateChatEscalationStatusHistoryUseCase updateUseCase;
    private final GetChatEscalationStatusHistoryUseCase getUseCase;
    private final DeleteChatEscalationStatusHistoryUseCase deleteUseCase;

    public ChatEscalationStatusHistoryRestController(ChatEscalationStatusHistoryRepositoryPort repository) {
        ChatEscalationStatusHistoryApplicationService service = new ChatEscalationStatusHistoryApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ChatEscalationStatusHistoryResponse> create(@RequestBody CreateChatEscalationStatusHistoryWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatEscalationStatusHistoryResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ChatEscalationStatusHistoryResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatEscalationStatusHistoryResponse> update(@PathVariable UUID id, @RequestBody UpdateChatEscalationStatusHistoryWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
