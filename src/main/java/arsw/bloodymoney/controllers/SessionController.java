package arsw.bloodymoney.controllers;


import arsw.bloodymoney.services.impl.InMemorySessionPersistence;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/sessions")
public class SessionController {


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllSessions() {
        try {
            ConcurrentHashMap chm = InMemorySessionPersistence.getSessions();
            return new ResponseEntity<>(chm, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
}
