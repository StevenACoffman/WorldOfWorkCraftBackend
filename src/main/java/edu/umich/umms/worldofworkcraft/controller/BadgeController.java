package edu.umich.umms.worldofworkcraft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.umich.umms.worldofworkcraft.domain.Badge;
import edu.umich.umms.worldofworkcraft.repository.BadgeRepository;

@Controller
@RequestMapping("/badges")
public class BadgeController {
    
    @Autowired
    BadgeRepository badgeRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Badge>> findBadges() {
        Iterable<Badge> badges = badgeRepository.findAll();
        return new ResponseEntity<Iterable<Badge>>(badges, HttpStatus.OK);
    }

}
