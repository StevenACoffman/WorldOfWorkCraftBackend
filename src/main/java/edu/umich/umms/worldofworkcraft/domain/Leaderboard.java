package edu.umich.umms.worldofworkcraft.domain;

/**
 * Created by maperiaz on 3/5/15.
 */
public class Leaderboard {
    private String name;
    private Long points;

    public Leaderboard(Learner learner){
        name = learner.getName();
        points = learner.aggregatePoints();
    }

    public Leaderboard(String name, Long points){
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }
}
