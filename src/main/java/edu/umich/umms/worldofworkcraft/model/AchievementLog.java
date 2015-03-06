package edu.umich.umms.worldofworkcraft.model;

import edu.umich.umms.worldofworkcraft.domain.Achievement;
import edu.umich.umms.worldofworkcraft.domain.Challenge;
import edu.umich.umms.worldofworkcraft.domain.Learner;
import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

public class AchievementLog {

   String uniqname;
   String achievementName;
    String verb;

    public String getUniqname() {
        return uniqname;
    }

    public void setUniqname(String uniqname) {
        this.uniqname = uniqname;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }
}
