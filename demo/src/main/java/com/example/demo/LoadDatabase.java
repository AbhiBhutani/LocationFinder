package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/**
* Data is persisted to In memory H2 database
* */

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(LocationRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Location("Bayswater", 6053)));
            log.info("Preloading " + repository.save(new Location("Maylands", 6056)));
        };
    }



}
