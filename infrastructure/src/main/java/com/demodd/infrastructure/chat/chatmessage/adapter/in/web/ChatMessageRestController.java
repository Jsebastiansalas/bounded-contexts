package com.demodd.infrastructure.chat.chatmessage.adapter.in.web;

import com.demodd.application.chat.chatmessage.dto.ChatMessageResponse;
import com.demodd.application.chat.chatmessage.port.in.CreateChatMessageUseCase;
import com.demodd.application.chat.chatmessage.port.in.DeleteChatMessageUseCase;
import com.demodd.application.chat.chatmessage.port.in.GetChatMessageUseCase;
import com.demodd.application.chat.chatmessage.port.in.UpdateChatMessageUseCase;
import com.demodd.application.chat.chatmessage.service.ChatMessageApplicationService;
import com.demodd.domain.chat.chatmessage.port.repository.ChatMessageRepositoryPort;
import com.demodd.infrastructure.chat.chatmessage.adapter.in.web.dto.CreateChatMessageWebRequest;
import com.demodd.infrastructure.chat.chatmessage.adapter.in.web.dto.UpdateChatMessageWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat/chatmessage")
public class ChatMessageRestController {

    private final CreateChatMessageUseCase createUseCase;
    private final UpdateChatMessageUseCase updateUseCase;
    private final GetChatMessageUseCase getUseCase;
    private final DeleteChatMessageUseCase deleteUseCase;

    public ChatMessageRestController(ChatMessageRepositoryPort repository) {
        ChatMessageApplicationService service = new ChatMessageApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ChatMessageResponse> create(@RequestBody CreateChatMessageWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatMessageResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ChatMessageResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatMessageResponse> update(@PathVariable UUID id, @RequestBody UpdateChatMessageWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
