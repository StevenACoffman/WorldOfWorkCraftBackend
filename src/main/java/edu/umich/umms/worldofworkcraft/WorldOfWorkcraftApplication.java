package edu.umich.umms.worldofworkcraft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorldOfWorkcraftApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorldOfWorkcraftApplication.class, args);
    }

    @Bean
    SpringRestGraphDatabase graphDatabaseService() {
        return new SpringRestGraphDatabase("http://localhost:7474/db/data");
    }
}
