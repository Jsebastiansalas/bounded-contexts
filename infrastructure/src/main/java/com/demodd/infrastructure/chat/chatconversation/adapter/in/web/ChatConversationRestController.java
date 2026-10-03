package com.demodd.infrastructure.chat.chatconversation.adapter.in.web;

import com.demodd.application.chat.chatconversation.dto.ChatConversationResponse;
import com.demodd.application.chat.chatconversation.port.in.CreateChatConversationUseCase;
import com.demodd.application.chat.chatconversation.port.in.DeleteChatConversationUseCase;
import com.demodd.application.chat.chatconversation.port.in.GetChatConversationUseCase;
import com.demodd.application.chat.chatconversation.port.in.UpdateChatConversationUseCase;
import com.demodd.application.chat.chatconversation.service.ChatConversationApplicationService;
import com.demodd.domain.chat.chatconversation.port.repository.ChatConversationRepositoryPort;
import com.demodd.infrastructure.chat.chatconversation.adapter.in.web.dto.CreateChatConversationWebRequest;
import com.demodd.infrastructure.chat.chatconversation.adapter.in.web.dto.UpdateChatConversationWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat/chatconversation")
public class ChatConversationRestController {

    private final CreateChatConversationUseCase createUseCase;
    private final UpdateChatConversationUseCase updateUseCase;
    private final GetChatConversationUseCase getUseCase;
    private final DeleteChatConversationUseCase deleteUseCase;

    public ChatConversationRestController(ChatConversationRepositoryPort repository) {
        ChatConversationApplicationService service = new ChatConversationApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ChatConversationResponse> create(@RequestBody CreateChatConversationWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatConversationResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ChatConversationResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatConversationResponse> update(@PathVariable UUID id, @RequestBody UpdateChatConversationWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
