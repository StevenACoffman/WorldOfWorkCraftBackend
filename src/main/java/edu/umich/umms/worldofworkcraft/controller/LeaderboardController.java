package edu.umich.umms.worldofworkcraft.controller;

import edu.umich.umms.worldofworkcraft.domain.Leaderboard;
import edu.umich.umms.worldofworkcraft.domain.Learner;
import edu.umich.umms.worldofworkcraft.repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/leaderboard")
public class LeaderboardController {

    @Autowired
    LearnerRepository learnerRepository;

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<Leaderboard>> getLeaderboard() {
        Iterable<Learner> learners = learnerRepository.findAll();
        List<Leaderboard> leaderboardList = new ArrayList<>();

         for (Learner  learner: learners) {
             Long points = learnerRepository.findPoints(learner.getUniqname());
             leaderboardList.add(new Leaderboard(learner.getName(),points));
         }
        return new ResponseEntity<List<Leaderboard>>(leaderboardList, HttpStatus.OK);
    }
}
