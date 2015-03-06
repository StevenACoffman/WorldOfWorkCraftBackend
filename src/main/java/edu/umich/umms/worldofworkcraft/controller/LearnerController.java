package edu.umich.umms.worldofworkcraft.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.umich.umms.worldofworkcraft.domain.Achievement;
import edu.umich.umms.worldofworkcraft.domain.Badge;
import edu.umich.umms.worldofworkcraft.domain.Learner;
import edu.umich.umms.worldofworkcraft.repository.BadgeRepository;
import edu.umich.umms.worldofworkcraft.repository.LearnerRepository;

@Controller
@RequestMapping("/learner")
public class LearnerController {

    @Autowired
    LearnerRepository learnerRepository;
    
    @Autowired
    BadgeRepository badgeRepository;

    @RequestMapping(value = "/{uniqname}", method = RequestMethod.GET)
    public ResponseEntity<Learner> findLearner(@PathVariable String uniqname) {
        Iterable<Learner> learners = learnerRepository.findByUniqname(uniqname);
        if (learners.iterator().hasNext()) {
            return new ResponseEntity<Learner>(learners.iterator().next(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Learner>( HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "s", method = RequestMethod.GET)
    public ResponseEntity<Learner> findAllLearners() {
        Iterable<Learner> learners = learnerRepository.findAll();
        if (learners.iterator().hasNext()) {
            return new ResponseEntity<Learner>(learners.iterator().next(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Learner>( HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value = "/{uniqname}/achievements", method = RequestMethod.GET)
    public ResponseEntity<Set<Achievement>> findAchievements(@PathVariable String uniqname) {
        Iterable<Learner> learners = learnerRepository.findByUniqname(uniqname);
        if (learners.iterator().hasNext()) {
            return new ResponseEntity<Set<Achievement>>(learners.iterator().next().getAchievements(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Set<Achievement>>(new HashSet<Achievement>(), HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/{uniqname}/badges", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Badge>> findBadges(@PathVariable String uniqname) {
        Iterable<Badge> badges = badgeRepository.findBadgesByUniqname(uniqname);
        if (badges.iterator().hasNext()) {
            return new ResponseEntity<Iterable<Badge>>(badges, HttpStatus.OK);
        } else {
            return new ResponseEntity<Iterable<Badge>>(new ArrayList<Badge>(), HttpStatus.OK);
        }
    }
}
