package com.canmogol;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import reactor.core.publisher.Flux;

@Controller("/city")
public class CityController {

    private final CityRepository repository;

    public CityController(CityRepository repository) {
        this.repository = repository;
    }

    @Get
    Flux<City> all() {
        return repository.findAll();
    }

}
