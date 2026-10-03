package com.demodd.infrastructure.geography.relationshiptype.adapter.in.web;

import com.demodd.application.geography.relationshiptype.dto.RelationshipTypeResponse;
import com.demodd.application.geography.relationshiptype.port.in.CreateRelationshipTypeUseCase;
import com.demodd.application.geography.relationshiptype.port.in.DeleteRelationshipTypeUseCase;
import com.demodd.application.geography.relationshiptype.port.in.GetRelationshipTypeUseCase;
import com.demodd.application.geography.relationshiptype.port.in.UpdateRelationshipTypeUseCase;
import com.demodd.application.geography.relationshiptype.service.RelationshipTypeApplicationService;
import com.demodd.domain.geography.relationshiptype.port.repository.RelationshipTypeRepositoryPort;
import com.demodd.infrastructure.geography.relationshiptype.adapter.in.web.dto.CreateRelationshipTypeWebRequest;
import com.demodd.infrastructure.geography.relationshiptype.adapter.in.web.dto.UpdateRelationshipTypeWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/geography/relationshiptype")
public class RelationshipTypeRestController {

    private final CreateRelationshipTypeUseCase createUseCase;
    private final UpdateRelationshipTypeUseCase updateUseCase;
    private final GetRelationshipTypeUseCase getUseCase;
    private final DeleteRelationshipTypeUseCase deleteUseCase;

    public RelationshipTypeRestController(RelationshipTypeRepositoryPort repository) {
        RelationshipTypeApplicationService service = new RelationshipTypeApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<RelationshipTypeResponse> create(@RequestBody CreateRelationshipTypeWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelationshipTypeResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<RelationshipTypeResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RelationshipTypeResponse> update(@PathVariable UUID id, @RequestBody UpdateRelationshipTypeWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
