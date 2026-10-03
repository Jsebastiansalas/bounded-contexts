package com.demodd.domain.geography.citymunicipality.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class CityMunicipalityStatus implements ValueObject {

    private final String value;

    public CityMunicipalityStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static CityMunicipalityStatus of(String value) {
        return new CityMunicipalityStatus(value);
    }

    public static CityMunicipalityStatus active() {
        return new CityMunicipalityStatus("ACTIVE");
    }

    public static CityMunicipalityStatus inactive() {
        return new CityMunicipalityStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityMunicipalityStatus that = (CityMunicipalityStatus) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
