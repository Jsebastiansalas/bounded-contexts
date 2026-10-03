package com.demodd.infrastructure.chat.chatparticipant.adapter.in.web;

import com.demodd.application.chat.chatparticipant.dto.ChatParticipantResponse;
import com.demodd.application.chat.chatparticipant.port.in.CreateChatParticipantUseCase;
import com.demodd.application.chat.chatparticipant.port.in.DeleteChatParticipantUseCase;
import com.demodd.application.chat.chatparticipant.port.in.GetChatParticipantUseCase;
import com.demodd.application.chat.chatparticipant.port.in.UpdateChatParticipantUseCase;
import com.demodd.application.chat.chatparticipant.service.ChatParticipantApplicationService;
import com.demodd.domain.chat.chatparticipant.port.repository.ChatParticipantRepositoryPort;
import com.demodd.infrastructure.chat.chatparticipant.adapter.in.web.dto.CreateChatParticipantWebRequest;
import com.demodd.infrastructure.chat.chatparticipant.adapter.in.web.dto.UpdateChatParticipantWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat/chatparticipant")
public class ChatParticipantRestController {

    private final CreateChatParticipantUseCase createUseCase;
    private final UpdateChatParticipantUseCase updateUseCase;
    private final GetChatParticipantUseCase getUseCase;
    private final DeleteChatParticipantUseCase deleteUseCase;

    public ChatParticipantRestController(ChatParticipantRepositoryPort repository) {
        ChatParticipantApplicationService service = new ChatParticipantApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ChatParticipantResponse> create(@RequestBody CreateChatParticipantWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatParticipantResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ChatParticipantResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatParticipantResponse> update(@PathVariable UUID id, @RequestBody UpdateChatParticipantWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
