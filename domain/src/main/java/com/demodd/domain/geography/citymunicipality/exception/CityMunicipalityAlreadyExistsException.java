package com.demodd.domain.geography.citymunicipality.exception;

import com.demodd.domain.common.DomainException;

public class CityMunicipalityAlreadyExistsException extends DomainException {

    public CityMunicipalityAlreadyExistsException(String identifier) {
        super("Ya existe un registro de CityMunicipality con identificador: " + identifier);
    }
}
