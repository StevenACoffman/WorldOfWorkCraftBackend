package edu.umich.umms.worldofworkcraft.controller;

import edu.umich.umms.worldofworkcraft.domain.Learner;
import edu.umich.umms.worldofworkcraft.repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/learner")
public class LearnerController {

    @Autowired
    LearnerRepository learnerRepository;

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
}
