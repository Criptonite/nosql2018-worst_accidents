package com.leti.server;

import com.leti.server.repositories.CityRepository;
import com.leti.server.repositories.RegionsRepository;
import com.leti.server.repositories.RegionsWithAccidentsRepository;
import com.leti.server.repositories.TypesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {
        CityRepository.class,
        RegionsRepository.class,
        TypesRepository.class,
        RegionsWithAccidentsRepository.class})
public class WorstsccApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorstsccApplication.class, args);
    }
}
