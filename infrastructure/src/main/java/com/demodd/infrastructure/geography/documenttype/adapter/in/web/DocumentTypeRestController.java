package com.demodd.infrastructure.geography.documenttype.adapter.in.web;

import com.demodd.application.geography.documenttype.dto.DocumentTypeResponse;
import com.demodd.application.geography.documenttype.port.in.CreateDocumentTypeUseCase;
import com.demodd.application.geography.documenttype.port.in.DeleteDocumentTypeUseCase;
import com.demodd.application.geography.documenttype.port.in.GetDocumentTypeUseCase;
import com.demodd.application.geography.documenttype.port.in.UpdateDocumentTypeUseCase;
import com.demodd.application.geography.documenttype.service.DocumentTypeApplicationService;
import com.demodd.domain.geography.documenttype.port.repository.DocumentTypeRepositoryPort;
import com.demodd.infrastructure.geography.documenttype.adapter.in.web.dto.CreateDocumentTypeWebRequest;
import com.demodd.infrastructure.geography.documenttype.adapter.in.web.dto.UpdateDocumentTypeWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/geography/documenttype")
public class DocumentTypeRestController {

    private final CreateDocumentTypeUseCase createUseCase;
    private final UpdateDocumentTypeUseCase updateUseCase;
    private final GetDocumentTypeUseCase getUseCase;
    private final DeleteDocumentTypeUseCase deleteUseCase;

    public DocumentTypeRestController(DocumentTypeRepositoryPort repository) {
        DocumentTypeApplicationService service = new DocumentTypeApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<DocumentTypeResponse> create(@RequestBody CreateDocumentTypeWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentTypeResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DocumentTypeResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentTypeResponse> update(@PathVariable UUID id, @RequestBody UpdateDocumentTypeWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
