package edu.umich.umms.worldofworkcraft.repository;

import edu.umich.umms.worldofworkcraft.domain.Achievement;
import edu.umich.umms.worldofworkcraft.domain.Learner;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface AchievementRepository extends GraphRepository<Achievement> {

}
