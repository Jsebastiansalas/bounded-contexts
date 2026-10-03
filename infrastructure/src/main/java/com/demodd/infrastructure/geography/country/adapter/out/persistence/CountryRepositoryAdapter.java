package com.demodd.infrastructure.geography.country.adapter.out.persistence;

import com.demodd.domain.geography.country.model.aggregate.Country;
import com.demodd.domain.geography.country.model.valueobject.CountryId;
import com.demodd.domain.geography.country.model.valueobject.CountryName;
import com.demodd.domain.geography.country.model.valueobject.CountryStatus;
import com.demodd.domain.geography.country.port.repository.CountryRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CountryRepositoryAdapter implements CountryRepositoryPort {

    private final CountrySpringDataJpaRepository repository;

    public CountryRepositoryAdapter(CountrySpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Country save(Country entity) {
        CountryJpaEntity jpaEntity = new CountryJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        CountryJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<Country> findById(CountryId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<Country> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(CountryId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(CountryId id) {
        return repository.existsById(id.value());
    }

    private Country toDomain(CountryJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new Country(
                CountryId.of(jpa.getId()),
                CountryName.of(entityName),
                CountryStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
