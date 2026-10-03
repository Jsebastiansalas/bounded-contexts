package com.demodd.infrastructure.patient.contact.adapter.in.web;

import com.demodd.application.patient.contact.dto.ContactResponse;
import com.demodd.application.patient.contact.port.in.CreateContactUseCase;
import com.demodd.application.patient.contact.port.in.DeleteContactUseCase;
import com.demodd.application.patient.contact.port.in.GetContactUseCase;
import com.demodd.application.patient.contact.port.in.UpdateContactUseCase;
import com.demodd.application.patient.contact.service.ContactApplicationService;
import com.demodd.domain.patient.contact.port.repository.ContactRepositoryPort;
import com.demodd.infrastructure.patient.contact.adapter.in.web.dto.CreateContactWebRequest;
import com.demodd.infrastructure.patient.contact.adapter.in.web.dto.UpdateContactWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/patient/contact")
public class ContactRestController {

    private final CreateContactUseCase createUseCase;
    private final UpdateContactUseCase updateUseCase;
    private final GetContactUseCase getUseCase;
    private final DeleteContactUseCase deleteUseCase;

    public ContactRestController(ContactRepositoryPort repository) {
        ContactApplicationService service = new ContactApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ContactResponse> create(@RequestBody CreateContactWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactResponse> update(@PathVariable UUID id, @RequestBody UpdateContactWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
