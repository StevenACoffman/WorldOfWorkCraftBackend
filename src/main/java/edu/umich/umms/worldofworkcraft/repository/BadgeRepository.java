package edu.umich.umms.worldofworkcraft.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import edu.umich.umms.worldofworkcraft.domain.Badge;

public interface BadgeRepository extends GraphRepository<Badge> {
    
    @Query("match (l:Learner {uniqname:{0}})-[r*..2]-(b:Badge) with count(r) as bcount, b where bcount>=b.requiresCount return b")
    public Iterable<Badge> findBadgesByUniqname(String uniqname);

}
