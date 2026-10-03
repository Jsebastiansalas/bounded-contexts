package com.demodd.domain.geography.citymunicipality.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class CityMunicipalityId implements ValueObject {

    private final UUID value;

    public CityMunicipalityId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de CityMunicipalityId no puede ser nulo");
    }

    public static CityMunicipalityId of(UUID value) {
        return new CityMunicipalityId(value);
    }

    public static CityMunicipalityId of(String value) {
        return new CityMunicipalityId(UUID.fromString(value));
    }

    public static CityMunicipalityId random() {
        return new CityMunicipalityId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityMunicipalityId that = (CityMunicipalityId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
