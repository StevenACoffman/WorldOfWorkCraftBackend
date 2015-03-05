package edu.umich.umms.worldofworkcraft.controller;

import edu.umich.umms.worldofworkcraft.domain.Challenge;
import edu.umich.umms.worldofworkcraft.domain.Learner;
import edu.umich.umms.worldofworkcraft.repository.ChallengeRepository;
import edu.umich.umms.worldofworkcraft.repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/challenges")
public class ChallengeController {
    @Autowired
    ChallengeRepository challengeRepository;

    @RequestMapping(value = "/{uniqname}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Challenge>> findChallenges(@PathVariable String uniqname) {


        Iterable<Challenge> challenges = challengeRepository.findByUniqname(uniqname);
        if (challenges.iterator().hasNext()) {
            return new ResponseEntity<Iterable<Challenge>>(challenges, HttpStatus.OK);
        } else {
            return new ResponseEntity<Iterable<Challenge>>( HttpStatus.NOT_FOUND);
        }
    }
}
