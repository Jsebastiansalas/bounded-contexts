package com.demodd.infrastructure.chat.chatconversationaisetting.adapter.in.web;

import com.demodd.application.chat.chatconversationaisetting.dto.ChatConversationAiSettingResponse;
import com.demodd.application.chat.chatconversationaisetting.port.in.CreateChatConversationAiSettingUseCase;
import com.demodd.application.chat.chatconversationaisetting.port.in.DeleteChatConversationAiSettingUseCase;
import com.demodd.application.chat.chatconversationaisetting.port.in.GetChatConversationAiSettingUseCase;
import com.demodd.application.chat.chatconversationaisetting.port.in.UpdateChatConversationAiSettingUseCase;
import com.demodd.application.chat.chatconversationaisetting.service.ChatConversationAiSettingApplicationService;
import com.demodd.domain.chat.chatconversationaisetting.port.repository.ChatConversationAiSettingRepositoryPort;
import com.demodd.infrastructure.chat.chatconversationaisetting.adapter.in.web.dto.CreateChatConversationAiSettingWebRequest;
import com.demodd.infrastructure.chat.chatconversationaisetting.adapter.in.web.dto.UpdateChatConversationAiSettingWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat/chatconversationaisetting")
public class ChatConversationAiSettingRestController {

    private final CreateChatConversationAiSettingUseCase createUseCase;
    private final UpdateChatConversationAiSettingUseCase updateUseCase;
    private final GetChatConversationAiSettingUseCase getUseCase;
    private final DeleteChatConversationAiSettingUseCase deleteUseCase;

    public ChatConversationAiSettingRestController(ChatConversationAiSettingRepositoryPort repository) {
        ChatConversationAiSettingApplicationService service = new ChatConversationAiSettingApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ChatConversationAiSettingResponse> create(@RequestBody CreateChatConversationAiSettingWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatConversationAiSettingResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ChatConversationAiSettingResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatConversationAiSettingResponse> update(@PathVariable UUID id, @RequestBody UpdateChatConversationAiSettingWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
