package com.demodd.infrastructure.patient.patientcontact.adapter.in.web;

import com.demodd.application.patient.patientcontact.dto.PatientContactResponse;
import com.demodd.application.patient.patientcontact.port.in.CreatePatientContactUseCase;
import com.demodd.application.patient.patientcontact.port.in.DeletePatientContactUseCase;
import com.demodd.application.patient.patientcontact.port.in.GetPatientContactUseCase;
import com.demodd.application.patient.patientcontact.port.in.UpdatePatientContactUseCase;
import com.demodd.application.patient.patientcontact.service.PatientContactApplicationService;
import com.demodd.domain.patient.patientcontact.port.repository.PatientContactRepositoryPort;
import com.demodd.infrastructure.patient.patientcontact.adapter.in.web.dto.CreatePatientContactWebRequest;
import com.demodd.infrastructure.patient.patientcontact.adapter.in.web.dto.UpdatePatientContactWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/patient/patientcontact")
public class PatientContactRestController {

    private final CreatePatientContactUseCase createUseCase;
    private final UpdatePatientContactUseCase updateUseCase;
    private final GetPatientContactUseCase getUseCase;
    private final DeletePatientContactUseCase deleteUseCase;

    public PatientContactRestController(PatientContactRepositoryPort repository) {
        PatientContactApplicationService service = new PatientContactApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<PatientContactResponse> create(@RequestBody CreatePatientContactWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientContactResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PatientContactResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientContactResponse> update(@PathVariable UUID id, @RequestBody UpdatePatientContactWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
