package edu.umich.umms.worldofworkcraft.controller;

import edu.umich.umms.worldofworkcraft.domain.Achievement;
import edu.umich.umms.worldofworkcraft.domain.Learner;
import edu.umich.umms.worldofworkcraft.repository.AchievementRepository;
import edu.umich.umms.worldofworkcraft.repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/achievement")

public class AchievementController {
    @Autowired
    AchievementRepository achievementRepository;


   // @RequestMapping(value = "/find/{achievement}", method = RequestMethod.GET)
//    public String findById(@PathVariable Long id) {
//        List<Achievement> achievements = achievementRepository.findAll();
//        return achievement.getName();
//    }
}
