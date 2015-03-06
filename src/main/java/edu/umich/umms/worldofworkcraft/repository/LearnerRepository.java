package edu.umich.umms.worldofworkcraft.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import edu.umich.umms.worldofworkcraft.domain.Learner;

public interface LearnerRepository extends GraphRepository<Learner> {

    @Query("match (l:Learner {uniqname:{0}}) return l")
    public Iterable<Learner> findByUniqname(String uniqname);

    @Query("match (l:Learner {uniqname:{0}})-[r]-(a:Achievement) return sum(a.points)")
    public Long findPoints(String uniqname);

}
