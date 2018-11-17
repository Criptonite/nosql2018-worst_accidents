package com.leti.server.repositories;

import com.leti.server.entities.City;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends MongoRepository<City, String> {
    City findCityByName(String name);

    City findCityById(String id);
}
