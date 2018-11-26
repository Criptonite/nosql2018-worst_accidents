package com.leti.server.repositories;

import com.leti.server.entities.Accident;
import com.leti.server.entities.DeathTsDependency;
import com.leti.server.entities.ManWoman;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccidentRepository extends MongoRepository<Accident, String> {

    List<Accident> findAccidentByRegionAndDateEndingWith(String region, String year);

    List<Accident> findAccidentByTypeAndDateEndingWith(String type, String year);

    List<Accident> findAccidentByRegionAndTypeAndDateEndingWith(String region, String type, String year);

    @Query(value = "{$and: [{name: ?0}, {date: {$regex: '?1'}}, {$or:[{'dtp_info.uch_info.state' : {$regex: 'Скончался*'}}, {'dtp_info.ts_info.uch_info.state': {$regex: 'Скончался*'}}]}]}", count = true)
    Integer countAccidentsWithDeath(String region, String valueOf);

    @Query(value = "{$and: [{name: ?0}, {date: {$regex: '?1'}}, {$or:[{'dtp_info.uch_info.state' : {$regex: 'Скончался*'}}, {'dtp_info.ts_info.uch_info.state': {$regex: 'Скончался*'}}]}]}")
    List<Accident> findAccidentWithDeath(String region, String valueOf);

    @Query("{}")
    ManWoman countGuiltyManWomanInRegion(String name, String valueOf);

    @Query("{}")
    DeathTsDependency countDeathTsDependancyInRegion(String name, String valueOf);
}
