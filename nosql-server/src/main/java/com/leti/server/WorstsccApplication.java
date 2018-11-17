package com.leti.server;

import com.leti.server.repositories.CityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = CityRepository.class)
public class WorstsccApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorstsccApplication.class, args);
    }
}
