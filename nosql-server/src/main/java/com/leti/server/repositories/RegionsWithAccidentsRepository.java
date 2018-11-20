package com.leti.server.repositories;

import com.leti.server.entities.RegionWithAccidents;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionsWithAccidentsRepository extends MongoRepository<RegionWithAccidents, String> {
}
