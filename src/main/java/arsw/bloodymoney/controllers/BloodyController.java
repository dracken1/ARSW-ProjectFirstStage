
package arsw.bloodymoney.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import arsw.bloodymoney.DBconnection.Bridge;
import arsw.bloodymoney.entities.User;
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

    @RequestMapping(method = RequestMethod.POST , path = "/add")
    public ResponseEntity<?> createNewPlayer(@RequestBody User user) {
        try {
            Bridge bg = new Bridge();
            Boolean res = bg.addUser(user.getName(),
                                        user.getLastname(),
                                        user.getUsername(),
                                        user.getEmail(),
                                        user.getPassword());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(BloodyController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 403", HttpStatus.FORBIDDEN);
        }
    }
}