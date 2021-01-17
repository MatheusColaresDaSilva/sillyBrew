package com.beer.configuration;

import com.beer.model.Recipe;
import com.beer.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(RecipeRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Recipe("IPA 1", "Matheus", "IPA", "20", 58L)));
            log.info("Preloading " + repository.save(new Recipe("Creme Ale", "Matheus", "Cream Ale", "20", 58L)));
            log.info("Preloading " + repository.save(new Recipe("Deadline", "Matheus", "Red Ale", "20", 58L)));

        };
    }
}
