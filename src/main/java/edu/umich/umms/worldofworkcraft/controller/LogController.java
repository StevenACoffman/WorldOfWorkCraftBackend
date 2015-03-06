package edu.umich.umms.worldofworkcraft.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.umich.umms.worldofworkcraft.domain.Achievement;
import edu.umich.umms.worldofworkcraft.domain.Learner;
import edu.umich.umms.worldofworkcraft.model.AchievementLog;
import edu.umich.umms.worldofworkcraft.repository.AchievementRepository;
import edu.umich.umms.worldofworkcraft.repository.ChallengeRepository;
import edu.umich.umms.worldofworkcraft.repository.LearnerRepository;

@Controller
@RequestMapping("/logger")
public class LogController {

    @Autowired
    AchievementRepository achievementRepository;

    @Autowired
    LearnerRepository learnerRepository;

    @Autowired
    ChallengeRepository challengeRepository;

    @Autowired
    Neo4jTemplate template;

    @ResponseBody
    @RequestMapping(value = "/log", method = RequestMethod.POST)
    public void log(@RequestBody AchievementLog achievementLog, HttpServletRequest request) throws IOException {
        Iterable<Learner> learners = learnerRepository.findByUniqname(achievementLog.getUniqname());
        Learner learner = null;
        if (learners.iterator().hasNext()) {
           learner = learners.iterator().next();
        } else {
            // oops?
        }
        Iterable<Achievement> achievements = achievementRepository.findByAchievementName(achievementLog.getAchievementName());
        Achievement achievement = null;
        if (achievements.iterator().hasNext()) {
            achievement = achievements.iterator().next();
        } else {
            // ruh roh
        }

        learner.achievements.add(achievement);
        learnerRepository.save(learner);
    }
}
