package com.leti.server.repositories;

import com.leti.server.entities.Accident;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccidentRepository extends MongoRepository<Accident, String> {

    List<Accident> findAccidentByRegionAndDateEndingWith(String region, String year);

    List<Accident> findAccidentByTypeAndDateEndingWith(String type, String year);

    List<Accident> findAccidentByRegionAndTypeAndDateEndingWith(String region, String type, String year);

}
