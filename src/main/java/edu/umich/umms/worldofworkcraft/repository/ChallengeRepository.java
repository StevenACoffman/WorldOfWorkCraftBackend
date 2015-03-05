package edu.umich.umms.worldofworkcraft.repository;

import edu.umich.umms.worldofworkcraft.domain.Challenge;
import edu.umich.umms.worldofworkcraft.domain.Learner;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface ChallengeRepository extends GraphRepository<Challenge> {

    @Query("match (l:Learner {uniqname:{0}})-[:ACCEPT]-(c:Challenge) return c")
    Iterable<Challenge> findByUniqname(String uniqname);

}
