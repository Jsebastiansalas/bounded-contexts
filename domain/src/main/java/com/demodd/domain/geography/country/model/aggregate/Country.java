package com.demodd.domain.geography.country.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.geography.country.event.CountryCreatedEvent;
import com.demodd.domain.geography.country.event.CountryUpdatedEvent;
import com.demodd.domain.geography.country.model.valueobject.CountryId;
import com.demodd.domain.geography.country.model.valueobject.CountryName;
import com.demodd.domain.geography.country.model.valueobject.CountryStatus;

import java.time.Instant;
import java.util.Objects;

public class Country extends AggregateRoot<CountryId> {

    private final CountryId id;
    private CountryName name;
    private CountryStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public Country(CountryId id, CountryName name, CountryStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : CountryStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static Country create(CountryName name) {
        CountryId id = CountryId.random();
        Country entity = new Country(id, name, CountryStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new CountryCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(CountryName name, CountryStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new CountryUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public CountryId getId() {
        return id;
    }

    public CountryName getName() {
        return name;
    }

    public CountryStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
