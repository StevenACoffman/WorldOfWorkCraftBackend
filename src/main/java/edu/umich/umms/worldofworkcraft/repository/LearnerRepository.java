package edu.umich.umms.worldofworkcraft.repository;

import edu.umich.umms.worldofworkcraft.domain.Learner;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.CrudRepository;

public interface LearnerRepository extends GraphRepository<Learner> {

    @Query("match (l:Learner {uniqname:{0}}) return l")
    Iterable<Learner> findByUniqname(String uniqname);
    @Query("match (l:Learner {uniqname:{0}})-[r]-(a:Achievement) return sum(a.point)")
    public Long findPoints(String uniqname);

}
