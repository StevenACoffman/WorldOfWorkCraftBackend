package edu.umich.umms.worldofworkcraft.domain;

import lombok.Data;


import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Learner {

    @GraphId
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniqname() {
        return uniqname;
    }

    public void setUniqname(String uniqname) {
        this.uniqname = uniqname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(Set<Challenge> challenges) {
        this.challenges = challenges;
    }

    public Set<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(Set<Achievement> achievements) {
        this.achievements = achievements;
    }

    private String uniqname;
    private String name;

    @RelatedTo(type="CHALLENGE", direction= Direction.OUTGOING)
    public @Fetch Set<Challenge> challenges;

    @RelatedTo(type="ACHIEVEMENT", direction= Direction.OUTGOING)
    public @Fetch Set<Achievement> achievements;

    //edges - verb functions
    private void learnStuff(Achievement achievement){
        checkAchievement();
        achievements.add(achievement);

    }

    private void applyStuff(Achievement achievement){
        checkAchievement();
        achievements.add(achievement);

    }

    private void teachStuff(Achievement achievement){
        checkAchievement();
        achievements.add(achievement);

    }

    private void acceptStuff(Challenge challenge){
        if (challenge != null) {
            challenges = new HashSet<Challenge>();
        }

    }

    private void checkAchievement() {
        if (achievements == null) {
            achievements = new HashSet<Achievement>();
        }
    }



}
