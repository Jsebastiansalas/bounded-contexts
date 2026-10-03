package com.demodd.infrastructure.geography.citymunicipality.adapter.out.persistence;

import com.demodd.domain.geography.citymunicipality.model.aggregate.CityMunicipality;
import com.demodd.domain.geography.citymunicipality.model.valueobject.CityMunicipalityId;
import com.demodd.domain.geography.citymunicipality.model.valueobject.CityMunicipalityName;
import com.demodd.domain.geography.citymunicipality.model.valueobject.CityMunicipalityStatus;
import com.demodd.domain.geography.citymunicipality.port.repository.CityMunicipalityRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CityMunicipalityRepositoryAdapter implements CityMunicipalityRepositoryPort {

    private final CityMunicipalitySpringDataJpaRepository repository;

    public CityMunicipalityRepositoryAdapter(CityMunicipalitySpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public CityMunicipality save(CityMunicipality entity) {
        CityMunicipalityJpaEntity jpaEntity = new CityMunicipalityJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        CityMunicipalityJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<CityMunicipality> findById(CityMunicipalityId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<CityMunicipality> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(CityMunicipalityId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(CityMunicipalityId id) {
        return repository.existsById(id.value());
    }

    private CityMunicipality toDomain(CityMunicipalityJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new CityMunicipality(
                CityMunicipalityId.of(jpa.getId()),
                CityMunicipalityName.of(entityName),
                CityMunicipalityStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
