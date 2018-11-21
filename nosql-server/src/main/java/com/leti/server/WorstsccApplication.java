package com.leti.server;

import com.leti.server.repositories.AccidentRepository;
import com.leti.server.repositories.RegionsRepository;
import com.leti.server.repositories.TypesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {
        RegionsRepository.class,
        TypesRepository.class,
        AccidentRepository.class})
public class WorstsccApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorstsccApplication.class, args);
    }
}
