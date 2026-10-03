package com.demodd.infrastructure.patient.phonecontact.adapter.in.web;

import com.demodd.application.patient.phonecontact.dto.PhoneContactResponse;
import com.demodd.application.patient.phonecontact.port.in.CreatePhoneContactUseCase;
import com.demodd.application.patient.phonecontact.port.in.DeletePhoneContactUseCase;
import com.demodd.application.patient.phonecontact.port.in.GetPhoneContactUseCase;
import com.demodd.application.patient.phonecontact.port.in.UpdatePhoneContactUseCase;
import com.demodd.application.patient.phonecontact.service.PhoneContactApplicationService;
import com.demodd.domain.patient.phonecontact.port.repository.PhoneContactRepositoryPort;
import com.demodd.infrastructure.patient.phonecontact.adapter.in.web.dto.CreatePhoneContactWebRequest;
import com.demodd.infrastructure.patient.phonecontact.adapter.in.web.dto.UpdatePhoneContactWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/patient/phonecontact")
public class PhoneContactRestController {

    private final CreatePhoneContactUseCase createUseCase;
    private final UpdatePhoneContactUseCase updateUseCase;
    private final GetPhoneContactUseCase getUseCase;
    private final DeletePhoneContactUseCase deleteUseCase;

    public PhoneContactRestController(PhoneContactRepositoryPort repository) {
        PhoneContactApplicationService service = new PhoneContactApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<PhoneContactResponse> create(@RequestBody CreatePhoneContactWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneContactResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PhoneContactResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhoneContactResponse> update(@PathVariable UUID id, @RequestBody UpdatePhoneContactWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
