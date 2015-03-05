package edu.umich.umms.worldofworkcraft;

import edu.umich.umms.worldofworkcraft.domain.Learner;
import edu.umich.umms.worldofworkcraft.repository.LearnerRepository;
import org.neo4j.graphdb.Transaction;
import org.neo4j.kernel.impl.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;

import java.io.File;

@SpringBootApplication
@EnableNeo4jRepositories(basePackages = "edu.umich.umms.worldofworkcraft")
public class WorldOfWorkcraftApplication extends Neo4jConfiguration {

    public WorldOfWorkcraftApplication() {
        setBasePackage("edu.umich.umms.worldofworkcraft");
    }

    public static void main(String[] args) {
        SpringApplication.run(WorldOfWorkcraftApplication.class, args);
    }

    @Bean
    SpringRestGraphDatabase graphDatabaseService() {
        return new SpringRestGraphDatabase("http://localhost:7474/db/data");
    }



}
