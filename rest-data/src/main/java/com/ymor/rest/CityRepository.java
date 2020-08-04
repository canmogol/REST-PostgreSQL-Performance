package com.ymor.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "city", path = "city")
public interface CityRepository extends PagingAndSortingRepository<City, Long> {

    List<City> findByName(@Param("name") String name);

    List<City> findByCountrycode(@Param("countrycode") String countryCode);


    List<City> findByPopulationGreaterThanEqual(@Param("population") Long population);


    List<City> findByNameContaining(@Param("name") String name);

    List<City> findByNameContainingAndCountrycodeContaining(
            @Param("iname") String name,
            @Param("icountrycode") String countryCode
    );

    List<City> findByNameContainingAndCountrycodeContainingAndPopulationGreaterThanEqual(
            @Param("iname") String name,
            @Param("icountrycode") String countryCode,
            @Param("population") Long population
    );

}