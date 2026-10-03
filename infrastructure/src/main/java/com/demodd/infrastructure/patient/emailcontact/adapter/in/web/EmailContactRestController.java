package com.demodd.infrastructure.patient.emailcontact.adapter.in.web;

import com.demodd.application.patient.emailcontact.dto.EmailContactResponse;
import com.demodd.application.patient.emailcontact.port.in.CreateEmailContactUseCase;
import com.demodd.application.patient.emailcontact.port.in.DeleteEmailContactUseCase;
import com.demodd.application.patient.emailcontact.port.in.GetEmailContactUseCase;
import com.demodd.application.patient.emailcontact.port.in.UpdateEmailContactUseCase;
import com.demodd.application.patient.emailcontact.service.EmailContactApplicationService;
import com.demodd.domain.patient.emailcontact.port.repository.EmailContactRepositoryPort;
import com.demodd.infrastructure.patient.emailcontact.adapter.in.web.dto.CreateEmailContactWebRequest;
import com.demodd.infrastructure.patient.emailcontact.adapter.in.web.dto.UpdateEmailContactWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/patient/emailcontact")
public class EmailContactRestController {

    private final CreateEmailContactUseCase createUseCase;
    private final UpdateEmailContactUseCase updateUseCase;
    private final GetEmailContactUseCase getUseCase;
    private final DeleteEmailContactUseCase deleteUseCase;

    public EmailContactRestController(EmailContactRepositoryPort repository) {
        EmailContactApplicationService service = new EmailContactApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<EmailContactResponse> create(@RequestBody CreateEmailContactWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmailContactResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmailContactResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmailContactResponse> update(@PathVariable UUID id, @RequestBody UpdateEmailContactWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
