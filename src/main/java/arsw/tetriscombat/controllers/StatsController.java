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
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/stats")
public class StatsController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllSessions(@PathVariable("user") String username) {
        try {
            Bridge bg = new Bridge();
            Stats stats = bg.getUserStatistics(username);
            return new ResponseEntity<>(stats, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
}
