package com.demodd.domain.geography.citymunicipality.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.geography.citymunicipality.event.CityMunicipalityCreatedEvent;
import com.demodd.domain.geography.citymunicipality.event.CityMunicipalityUpdatedEvent;
import com.demodd.domain.geography.citymunicipality.model.valueobject.CityMunicipalityId;
import com.demodd.domain.geography.citymunicipality.model.valueobject.CityMunicipalityName;
import com.demodd.domain.geography.citymunicipality.model.valueobject.CityMunicipalityStatus;

import java.time.Instant;
import java.util.Objects;

public class CityMunicipality extends AggregateRoot<CityMunicipalityId> {

    private final CityMunicipalityId id;
    private CityMunicipalityName name;
    private CityMunicipalityStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public CityMunicipality(CityMunicipalityId id, CityMunicipalityName name, CityMunicipalityStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : CityMunicipalityStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static CityMunicipality create(CityMunicipalityName name) {
        CityMunicipalityId id = CityMunicipalityId.random();
        CityMunicipality entity = new CityMunicipality(id, name, CityMunicipalityStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new CityMunicipalityCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(CityMunicipalityName name, CityMunicipalityStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new CityMunicipalityUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public CityMunicipalityId getId() {
        return id;
    }

    public CityMunicipalityName getName() {
        return name;
    }

    public CityMunicipalityStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
