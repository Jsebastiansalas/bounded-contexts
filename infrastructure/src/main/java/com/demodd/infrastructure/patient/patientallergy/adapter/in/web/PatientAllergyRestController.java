package com.demodd.infrastructure.patient.patientallergy.adapter.in.web;

import com.demodd.application.patient.patientallergy.dto.PatientAllergyResponse;
import com.demodd.application.patient.patientallergy.port.in.CreatePatientAllergyUseCase;
import com.demodd.application.patient.patientallergy.port.in.DeletePatientAllergyUseCase;
import com.demodd.application.patient.patientallergy.port.in.GetPatientAllergyUseCase;
import com.demodd.application.patient.patientallergy.port.in.UpdatePatientAllergyUseCase;
import com.demodd.application.patient.patientallergy.service.PatientAllergyApplicationService;
import com.demodd.domain.patient.patientallergy.port.repository.PatientAllergyRepositoryPort;
import com.demodd.infrastructure.patient.patientallergy.adapter.in.web.dto.CreatePatientAllergyWebRequest;
import com.demodd.infrastructure.patient.patientallergy.adapter.in.web.dto.UpdatePatientAllergyWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/patient/patientallergy")
public class PatientAllergyRestController {

    private final CreatePatientAllergyUseCase createUseCase;
    private final UpdatePatientAllergyUseCase updateUseCase;
    private final GetPatientAllergyUseCase getUseCase;
    private final DeletePatientAllergyUseCase deleteUseCase;

    public PatientAllergyRestController(PatientAllergyRepositoryPort repository) {
        PatientAllergyApplicationService service = new PatientAllergyApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<PatientAllergyResponse> create(@RequestBody CreatePatientAllergyWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientAllergyResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PatientAllergyResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientAllergyResponse> update(@PathVariable UUID id, @RequestBody UpdatePatientAllergyWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
