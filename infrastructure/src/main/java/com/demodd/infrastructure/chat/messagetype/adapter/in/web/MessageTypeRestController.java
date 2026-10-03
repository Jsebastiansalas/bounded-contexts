package com.demodd.infrastructure.chat.messagetype.adapter.in.web;

import com.demodd.application.chat.messagetype.dto.MessageTypeResponse;
import com.demodd.application.chat.messagetype.port.in.CreateMessageTypeUseCase;
import com.demodd.application.chat.messagetype.port.in.DeleteMessageTypeUseCase;
import com.demodd.application.chat.messagetype.port.in.GetMessageTypeUseCase;
import com.demodd.application.chat.messagetype.port.in.UpdateMessageTypeUseCase;
import com.demodd.application.chat.messagetype.service.MessageTypeApplicationService;
import com.demodd.domain.chat.messagetype.port.repository.MessageTypeRepositoryPort;
import com.demodd.infrastructure.chat.messagetype.adapter.in.web.dto.CreateMessageTypeWebRequest;
import com.demodd.infrastructure.chat.messagetype.adapter.in.web.dto.UpdateMessageTypeWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat/messagetype")
public class MessageTypeRestController {

    private final CreateMessageTypeUseCase createUseCase;
    private final UpdateMessageTypeUseCase updateUseCase;
    private final GetMessageTypeUseCase getUseCase;
    private final DeleteMessageTypeUseCase deleteUseCase;

    public MessageTypeRestController(MessageTypeRepositoryPort repository) {
        MessageTypeApplicationService service = new MessageTypeApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<MessageTypeResponse> create(@RequestBody CreateMessageTypeWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageTypeResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<MessageTypeResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageTypeResponse> update(@PathVariable UUID id, @RequestBody UpdateMessageTypeWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
