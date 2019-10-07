
package com.bloody.app.bloodymoney.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.bloody.app.DBconnection.Bridge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hcadavid
 */
@RestController
@RequestMapping(value = "/session")
public class BloodyController {


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetRecursoBlueprints() {
        try {
            String res = "HELLO, WORLD!";
            return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(BloodyController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

    /*@RequestMapping(method = RequestMethod.GET, path = "{author}")
    public ResponseEntity<?> manejadorGetRecursoBlueprintsPorAutor(@PathVariable("author") String name) {
        try {

            return new ResponseEntity<>("", HttpStatus.ACCEPTED);
        } catch (ResourceNotFoundException ex) {
            Logger.getLogger(BloodyController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
    }*/

    @RequestMapping(method = RequestMethod.GET, path = "{user}/{password}")
    public ResponseEntity<?> verifyLogin(@PathVariable("user") String user, @PathVariable("password") String password) {
        try {
            Bridge bg = new Bridge();
            Boolean res = bg.authentication(user, password);
            return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(BloodyController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 404", HttpStatus.NOT_FOUND);
        }
    }

    /*@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> editPlayer() {
        try {

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(BloodyController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 403", HttpStatus.FORBIDDEN);
        }

    }*/

    @RequestMapping(method = RequestMethod.POST , path = "/add/{firstname}/{lastname}/{user}/{email}/{password}")
    public ResponseEntity<?> createNewPlayer(@PathVariable("firstname") String firstname,
                                             @PathVariable("lastname") String lastname,
                                             @PathVariable("user") String user,
                                             @PathVariable("email") String email,
                                             @PathVariable("password") String password) {
        try {
            Bridge bg = new Bridge();
            Boolean res = bg.addUser(firstname,lastname,user,email,password);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(BloodyController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 403", HttpStatus.FORBIDDEN);
        }
    }
}