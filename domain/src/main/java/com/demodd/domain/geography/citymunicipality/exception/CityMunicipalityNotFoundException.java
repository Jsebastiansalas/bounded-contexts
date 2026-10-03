package com.demodd.domain.geography.citymunicipality.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.geography.citymunicipality.model.valueobject.CityMunicipalityId;

public class CityMunicipalityNotFoundException extends DomainException {

    public CityMunicipalityNotFoundException(CityMunicipalityId id) {
        super("No se encontro la entidad CityMunicipality con identificador: " + id.value());
    }

    public CityMunicipalityNotFoundException(String message) {
        super(message);
    }
}
