package edu.umich.umms.worldofworkcraft.domain;

import lombok.Data;
import org.neo4j.cypherdsl.query.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@Data
@NodeEntity
public class Actor {

    @GraphId
    Long id;

    @RelatedTo(type="Neo4jObject", direction= Direction.BOTH)
    public @Fetch Neo4jObject professionalDevelopment;

    //Set<Person> teammates;

    //edges - verb functions
    private void learnStuff(Neo4jObject neo4JObject){
        if (neo4JObject == null) {
            neo4JObject = new HashSet<Person>();
        }
        teammates.add(person);

    }

    private void applyStuff(Neo4jObject neo4JObject){
        if (teammates == null) {
            teammates = new HashSet<Person>();
        }
        teammates.add(person);

    }

    private void teachStuff(Neo4jObject neo4JObject){
        if (teammates == null) {
            teammates = new HashSet<Person>();
        }
        teammates.add(person);

    }



}
