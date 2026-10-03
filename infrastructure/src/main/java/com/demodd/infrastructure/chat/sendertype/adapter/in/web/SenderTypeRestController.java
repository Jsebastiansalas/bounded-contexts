package com.demodd.infrastructure.chat.sendertype.adapter.in.web;

import com.demodd.application.chat.sendertype.dto.SenderTypeResponse;
import com.demodd.application.chat.sendertype.port.in.CreateSenderTypeUseCase;
import com.demodd.application.chat.sendertype.port.in.DeleteSenderTypeUseCase;
import com.demodd.application.chat.sendertype.port.in.GetSenderTypeUseCase;
import com.demodd.application.chat.sendertype.port.in.UpdateSenderTypeUseCase;
import com.demodd.application.chat.sendertype.service.SenderTypeApplicationService;
import com.demodd.domain.chat.sendertype.port.repository.SenderTypeRepositoryPort;
import com.demodd.infrastructure.chat.sendertype.adapter.in.web.dto.CreateSenderTypeWebRequest;
import com.demodd.infrastructure.chat.sendertype.adapter.in.web.dto.UpdateSenderTypeWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat/sendertype")
public class SenderTypeRestController {

    private final CreateSenderTypeUseCase createUseCase;
    private final UpdateSenderTypeUseCase updateUseCase;
    private final GetSenderTypeUseCase getUseCase;
    private final DeleteSenderTypeUseCase deleteUseCase;

    public SenderTypeRestController(SenderTypeRepositoryPort repository) {
        SenderTypeApplicationService service = new SenderTypeApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<SenderTypeResponse> create(@RequestBody CreateSenderTypeWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SenderTypeResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SenderTypeResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SenderTypeResponse> update(@PathVariable UUID id, @RequestBody UpdateSenderTypeWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
