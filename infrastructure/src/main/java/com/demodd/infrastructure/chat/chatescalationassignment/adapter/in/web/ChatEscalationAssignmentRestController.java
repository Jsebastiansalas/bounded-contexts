package com.demodd.infrastructure.chat.chatescalationassignment.adapter.in.web;

import com.demodd.application.chat.chatescalationassignment.dto.ChatEscalationAssignmentResponse;
import com.demodd.application.chat.chatescalationassignment.port.in.CreateChatEscalationAssignmentUseCase;
import com.demodd.application.chat.chatescalationassignment.port.in.DeleteChatEscalationAssignmentUseCase;
import com.demodd.application.chat.chatescalationassignment.port.in.GetChatEscalationAssignmentUseCase;
import com.demodd.application.chat.chatescalationassignment.port.in.UpdateChatEscalationAssignmentUseCase;
import com.demodd.application.chat.chatescalationassignment.service.ChatEscalationAssignmentApplicationService;
import com.demodd.domain.chat.chatescalationassignment.port.repository.ChatEscalationAssignmentRepositoryPort;
import com.demodd.infrastructure.chat.chatescalationassignment.adapter.in.web.dto.CreateChatEscalationAssignmentWebRequest;
import com.demodd.infrastructure.chat.chatescalationassignment.adapter.in.web.dto.UpdateChatEscalationAssignmentWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat/chatescalationassignment")
public class ChatEscalationAssignmentRestController {

    private final CreateChatEscalationAssignmentUseCase createUseCase;
    private final UpdateChatEscalationAssignmentUseCase updateUseCase;
    private final GetChatEscalationAssignmentUseCase getUseCase;
    private final DeleteChatEscalationAssignmentUseCase deleteUseCase;

    public ChatEscalationAssignmentRestController(ChatEscalationAssignmentRepositoryPort repository) {
        ChatEscalationAssignmentApplicationService service = new ChatEscalationAssignmentApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ChatEscalationAssignmentResponse> create(@RequestBody CreateChatEscalationAssignmentWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatEscalationAssignmentResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ChatEscalationAssignmentResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatEscalationAssignmentResponse> update(@PathVariable UUID id, @RequestBody UpdateChatEscalationAssignmentWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
