package com.demodd.infrastructure.geography.citymunicipality.adapter.in.web;

import com.demodd.application.geography.citymunicipality.dto.CityMunicipalityResponse;
import com.demodd.application.geography.citymunicipality.port.in.CreateCityMunicipalityUseCase;
import com.demodd.application.geography.citymunicipality.port.in.DeleteCityMunicipalityUseCase;
import com.demodd.application.geography.citymunicipality.port.in.GetCityMunicipalityUseCase;
import com.demodd.application.geography.citymunicipality.port.in.UpdateCityMunicipalityUseCase;
import com.demodd.application.geography.citymunicipality.service.CityMunicipalityApplicationService;
import com.demodd.domain.geography.citymunicipality.port.repository.CityMunicipalityRepositoryPort;
import com.demodd.infrastructure.geography.citymunicipality.adapter.in.web.dto.CreateCityMunicipalityWebRequest;
import com.demodd.infrastructure.geography.citymunicipality.adapter.in.web.dto.UpdateCityMunicipalityWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/geography/citymunicipality")
public class CityMunicipalityRestController {

    private final CreateCityMunicipalityUseCase createUseCase;
    private final UpdateCityMunicipalityUseCase updateUseCase;
    private final GetCityMunicipalityUseCase getUseCase;
    private final DeleteCityMunicipalityUseCase deleteUseCase;

    public CityMunicipalityRestController(CityMunicipalityRepositoryPort repository) {
        CityMunicipalityApplicationService service = new CityMunicipalityApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<CityMunicipalityResponse> create(@RequestBody CreateCityMunicipalityWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityMunicipalityResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CityMunicipalityResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityMunicipalityResponse> update(@PathVariable UUID id, @RequestBody UpdateCityMunicipalityWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
