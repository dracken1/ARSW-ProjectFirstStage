package arsw.tetriscombat.controllers;

import arsw.tetriscombat.mappers.Bridge;
import arsw.tetriscombat.entities.Session;
import arsw.tetriscombat.entities.User;
import arsw.tetriscombat.services.impl.InMemorySessionPersistence;
import arsw.tetriscombat.services.impl.UserServicesImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping(value = "/session")
public class UserController {

    UserServicesImpl usi = new UserServicesImpl();

    @RequestMapping(method = RequestMethod.GET, path="{prueba}")
    public ResponseEntity<?> manejadorGetRecursoBlueprints() {
        try {
            String res = "HELLO, WORLD!";
            return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

    // GET JUST USER, NOT HTTP CODE
    @RequestMapping(method = RequestMethod.GET, path = "{user}")
    public void getUserByEmail(@PathVariable("user") String user) {
        try {
            //! Revisar integracion de este con sesión
            //Bridge bg = new Bridge();
            //Boolean res = bg.authentication(user, password);
            //return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
            
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            //return new ResponseEntity<>("ERROR 404", HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> verifySession(@PathVariable("user") String user) {
        try {
            Bridge bg = new Bridge();
            User res = bg.getUserByEmail(user);
            if (res.getEmail() == null){
                return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 404", HttpStatus.NOT_FOUND);
        }
    }
    // DAO TERMINA DE CONSULTAR ACA EN CONTROLLER

    @RequestMapping(method = RequestMethod.GET, path = "{user}/{password}")
    public ResponseEntity<?> verifyLogin(@PathVariable("user") String username, @PathVariable("password") String password) {
        try {
            //Old implementation
            //Bridge bg = new Bridge();
            //User res = bg.authentication(username, password);

            //New implementation
            User res2 = usi.checkLogin(username,password);
            Session session = new Session(res2);
            InMemorySessionPersistence.sessions.put(res2,session);
            return new ResponseEntity<>(res2, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 404", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST , path = "/add")
    public ResponseEntity<?> createNewPlayer(@RequestBody User user) {
        try {
            usi.createElement(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 403", HttpStatus.FORBIDDEN);
        }
    }
}