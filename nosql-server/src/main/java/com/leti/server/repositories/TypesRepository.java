package com.leti.server.repositories;

import com.leti.server.entities.Type;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypesRepository extends MongoRepository<Type, String> {
}
