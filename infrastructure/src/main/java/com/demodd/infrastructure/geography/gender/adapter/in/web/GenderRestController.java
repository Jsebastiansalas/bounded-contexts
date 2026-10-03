package com.demodd.infrastructure.geography.gender.adapter.in.web;

import com.demodd.application.geography.gender.dto.GenderResponse;
import com.demodd.application.geography.gender.port.in.CreateGenderUseCase;
import com.demodd.application.geography.gender.port.in.DeleteGenderUseCase;
import com.demodd.application.geography.gender.port.in.GetGenderUseCase;
import com.demodd.application.geography.gender.port.in.UpdateGenderUseCase;
import com.demodd.application.geography.gender.service.GenderApplicationService;
import com.demodd.domain.geography.gender.port.repository.GenderRepositoryPort;
import com.demodd.infrastructure.geography.gender.adapter.in.web.dto.CreateGenderWebRequest;
import com.demodd.infrastructure.geography.gender.adapter.in.web.dto.UpdateGenderWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/geography/gender")
public class GenderRestController {

    private final CreateGenderUseCase createUseCase;
    private final UpdateGenderUseCase updateUseCase;
    private final GetGenderUseCase getUseCase;
    private final DeleteGenderUseCase deleteUseCase;

    public GenderRestController(GenderRepositoryPort repository) {
        GenderApplicationService service = new GenderApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<GenderResponse> create(@RequestBody CreateGenderWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenderResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<GenderResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenderResponse> update(@PathVariable UUID id, @RequestBody UpdateGenderWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
