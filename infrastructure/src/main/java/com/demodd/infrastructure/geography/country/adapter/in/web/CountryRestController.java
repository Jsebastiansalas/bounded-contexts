package com.demodd.infrastructure.geography.country.adapter.in.web;

import com.demodd.application.geography.country.dto.CountryResponse;
import com.demodd.application.geography.country.port.in.CreateCountryUseCase;
import com.demodd.application.geography.country.port.in.DeleteCountryUseCase;
import com.demodd.application.geography.country.port.in.GetCountryUseCase;
import com.demodd.application.geography.country.port.in.UpdateCountryUseCase;
import com.demodd.application.geography.country.service.CountryApplicationService;
import com.demodd.domain.geography.country.port.repository.CountryRepositoryPort;
import com.demodd.infrastructure.geography.country.adapter.in.web.dto.CreateCountryWebRequest;
import com.demodd.infrastructure.geography.country.adapter.in.web.dto.UpdateCountryWebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/geography/country")
public class CountryRestController {

    private final CreateCountryUseCase createUseCase;
    private final UpdateCountryUseCase updateUseCase;
    private final GetCountryUseCase getUseCase;
    private final DeleteCountryUseCase deleteUseCase;

    public CountryRestController(CountryRepositoryPort repository) {
        CountryApplicationService service = new CountryApplicationService(repository);
        this.createUseCase = service;
        this.updateUseCase = service;
        this.getUseCase = service;
        this.deleteUseCase = service;
    }

    @PostMapping
    public ResponseEntity<CountryResponse> create(@RequestBody CreateCountryWebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CountryResponse>> getAll() {
        return ResponseEntity.ok(getUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryResponse> update(@PathVariable UUID id, @RequestBody UpdateCountryWebRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request.name(), request.status()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
