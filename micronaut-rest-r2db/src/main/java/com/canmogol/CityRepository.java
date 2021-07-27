package com.canmogol;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.repository.reactive.ReactiveStreamsCrudRepository;
import reactor.core.publisher.Flux;

@R2dbcRepository(dialect = Dialect.POSTGRES)
public interface CityRepository extends ReactiveStreamsCrudRepository<City, Long> {

    @NonNull
    @Override
    Flux<City> findAll();

}
