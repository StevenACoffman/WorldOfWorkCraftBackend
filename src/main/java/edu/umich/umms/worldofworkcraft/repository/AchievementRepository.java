package edu.umich.umms.worldofworkcraft.repository;

import edu.umich.umms.worldofworkcraft.domain.Achievement;
import edu.umich.umms.worldofworkcraft.domain.Challenge;
import edu.umich.umms.worldofworkcraft.domain.Learner;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface AchievementRepository extends GraphRepository<Achievement> {
    @Query("match (l:Learner {uniqname:{0}})-[:LEARN]-(:Achievement) return l")
    Iterable<Achievement> findLearnedAchievementsByUniqname(String uniqname);
    @Query("match (a:Achievement {name:{0}}) return a")
    Iterable<Achievement> findByAchievementName(String achievementName);
}
