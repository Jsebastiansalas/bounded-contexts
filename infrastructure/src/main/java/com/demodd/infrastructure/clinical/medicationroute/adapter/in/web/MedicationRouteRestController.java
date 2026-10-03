package com.demodd.infrastructure.clinical.medicationroute.adapter.in.web;

import com.demodd.application.clinical.medicationroute.dto.MedicationRouteResponse;
import com.demodd.application.clinical.medicationroute.port.in.CreateMedicationRouteUseCase;
import com.demodd.application.clinical.medicationroute.port.in.DeleteMedicationRouteUseCase;
import com.demodd.application.clinical.medicationroute.port.in.GetMedicationRouteUseCase;
import com.demodd.application.clinical.medicationroute.port.in.UpdateMedicationRouteUseCase;
import com.demodd.application.clinical.medicationroute.service.MedicationRouteApplicationService;
import com.demodd.domain.clinical.medicationroute.port.repository.MedicationRouteRepositoryPort;
import com.demodd.infrastructure.clinical.medicationroute.adapter.in.web.dto.CreateMedicationRouteWebRequest;
import com.demodd.infrastructure.clinical.medicationroute.adapter.in.web.dto.UpdateMedicationRouteWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinical/medicationroute")
public class MedicationRouteRestController {

    private final CreateMedicationRouteUseCase createUseCase;
    private final UpdateMedicationRouteUseCase updateUseCase;
    private final GetMedicationRouteUseCase getUseCase;
    private final DeleteMedicationRouteUseCase deleteUseCase;

    public MedicationRouteRestController(MedicationRouteRepositoryPort repository) {
        MedicationRouteApplicationService service = new MedicationRouteApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<MedicationRouteResponse> create(@RequestBody CreateMedicationRouteWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationRouteResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<MedicationRouteResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicationRouteResponse> update(@PathVariable UUID id, @RequestBody UpdateMedicationRouteWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
