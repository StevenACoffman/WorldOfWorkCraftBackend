package edu.umich.umms.worldofworkcraft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.umich.umms.worldofworkcraft.domain.Achievement;
import edu.umich.umms.worldofworkcraft.repository.AchievementRepository;

@Controller
@RequestMapping("/achievement")

public class AchievementController {
    @Autowired
    AchievementRepository achievementRepository;
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Achievement> createAchievement(@RequestBody Achievement achievement) {
        return new ResponseEntity<Achievement>(achievementRepository.save(achievement), HttpStatus.OK);
    }


   // @RequestMapping(value = "/find/{achievement}", method = RequestMethod.GET)
//    public String findById(@PathVariable Long id) {
//        List<Achievement> achievements = achievementRepository.findAll();
//        return achievement.getName();
//    }
}
