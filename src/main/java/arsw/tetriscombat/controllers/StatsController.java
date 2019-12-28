package arsw.tetriscombat.controllers;

import arsw.tetriscombat.entities.Session;
import arsw.tetriscombat.entities.Stats;
import arsw.tetriscombat.entities.User;
import arsw.tetriscombat.mappers.Bridge;
import arsw.tetriscombat.services.impl.InMemorySessionPersistence;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/stats")
public class StatsController {

    @RequestMapping(method = RequestMethod.GET, path="{user}")
    public ResponseEntity<?> getAllSessions(@PathVariable("user") String username) {
        try {
            Bridge bg = new Bridge();
            ArrayList<Stats> stats = bg.getUserStatistics(username);
            return new ResponseEntity<>(stats, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST , path = "/stat")
    public ResponseEntity<?> createNewPlayer(@RequestBody Stats stat) {
        try {
            Bridge bg = new Bridge();
            bg.addStat(stat);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 403", HttpStatus.FORBIDDEN);
        }
    }
}