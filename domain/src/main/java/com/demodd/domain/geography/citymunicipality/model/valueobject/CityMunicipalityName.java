package com.demodd.domain.geography.citymunicipality.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class CityMunicipalityName implements ValueObject {

    private final String value;

    public CityMunicipalityName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de CityMunicipalityName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static CityMunicipalityName of(String value) {
        return new CityMunicipalityName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityMunicipalityName that = (CityMunicipalityName) o;
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
