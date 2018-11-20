package com.leti.server.repositories;

import com.leti.server.entities.Region;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionsRepository extends MongoRepository<Region, String> {
}
