package edu.umich.umms.worldofworkcraft.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import edu.umich.umms.worldofworkcraft.domain.Achievement;

public interface AchievementRepository extends GraphRepository<Achievement> {

    @Query("match (l:Learner {uniqname:{0}})-[:LEARN]-(:Achievement) return l")
    public Iterable<Achievement> findLearnedAchievementsByUniqname(String uniqname);

    @Query("match (a:Achievement {name:{0}}) return a")
    public Iterable<Achievement> findByAchievementName(String achievementName);
    
    @Query("match (l:Learner {uniqname:{0}})-[r]-(a:Achievement)-[rr]-(b:Badge {name:{1}}) return a")
    public Collection<Achievement> findByLearnerAndBadge(String uniqname, String badgeName);
}
