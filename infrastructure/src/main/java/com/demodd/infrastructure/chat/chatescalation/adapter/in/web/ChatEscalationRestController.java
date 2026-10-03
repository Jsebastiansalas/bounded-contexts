package com.demodd.infrastructure.chat.chatescalation.adapter.in.web;

import com.demodd.application.chat.chatescalation.dto.ChatEscalationResponse;
import com.demodd.application.chat.chatescalation.port.in.CreateChatEscalationUseCase;
import com.demodd.application.chat.chatescalation.port.in.DeleteChatEscalationUseCase;
import com.demodd.application.chat.chatescalation.port.in.GetChatEscalationUseCase;
import com.demodd.application.chat.chatescalation.port.in.UpdateChatEscalationUseCase;
import com.demodd.application.chat.chatescalation.service.ChatEscalationApplicationService;
import com.demodd.domain.chat.chatescalation.port.repository.ChatEscalationRepositoryPort;
import com.demodd.infrastructure.chat.chatescalation.adapter.in.web.dto.CreateChatEscalationWebRequest;
import com.demodd.infrastructure.chat.chatescalation.adapter.in.web.dto.UpdateChatEscalationWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat/chatescalation")
public class ChatEscalationRestController {

    private final CreateChatEscalationUseCase createUseCase;
    private final UpdateChatEscalationUseCase updateUseCase;
    private final GetChatEscalationUseCase getUseCase;
    private final DeleteChatEscalationUseCase deleteUseCase;

    public ChatEscalationRestController(ChatEscalationRepositoryPort repository) {
        ChatEscalationApplicationService service = new ChatEscalationApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ChatEscalationResponse> create(@RequestBody CreateChatEscalationWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatEscalationResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ChatEscalationResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatEscalationResponse> update(@PathVariable UUID id, @RequestBody UpdateChatEscalationWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
