package com.bloody.app.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hcadavid
 */
@RestController
@RequestMapping(value = "/login")
public class BloodyController {

    @Autowired
    //BloodyServices bServices;

    /**
     *
     * @return @throws
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers() {

        try {
            
            
            /*
            Map<String, Blueprint> blueprints = new HashMap();
            List<Blueprint> blueprintsArray = new ArrayList<>();
            blueprintsArray.addAll(bServices.getAllBlueprints());

            for (Blueprint x : blueprintsArray) {
                blueprints.put(x.getName(), x);
            }
            String codeToJson = new Gson().toJson(blueprints);*/
            return new ResponseEntity<>("BLABLABLA", HttpStatus.ACCEPTED);
            
        } catch (Exception ex) {
            Logger.getLogger(BloodyController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo obtener los usuarios", HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addNewUser(@RequestBody String user) {
        //Json example
        //{"bp05":{"author":"Carlos","points":[{"x":9,"y":9},{"x":10,"y":10}],"name":"bp05"}}
        try {
            
            
            //String Json to Map
            
            
            
            /*
            Type listType = new TypeToken<Map<String, Blueprint>>() {
            }.getType();
            Map<String, Blueprint> result = new Gson().fromJson(blueprint, listType);
            //Map Keys
            Object[] nameKeys = result.keySet().toArray();
            //Add product by getting Map objects
            bpServices.addNewBlueprint(result.get(nameKeys[0]));
            return new ResponseEntity<>(HttpStatus.CREATED);
            */

        } catch (Exception ex) {
            Logger.getLogger(BloodyController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo añadir el usuario", HttpStatus.FORBIDDEN);
        }
        return null;
    }
}













/*
Type listType = new TypeToken<Map<String, Blueprint>>() {
            }.getType();
            Map<String, Blueprint> result = new Gson().fromJson(blueprint, listType);
            //Map Keys
            Object[] nameKeys = result.keySet().toArray();
            //Add product by getting Map objects
            bpServices.addNewBlueprint(result.get(nameKeys[0]));
            return new ResponseEntity<>(HttpStatus.CREATED);
*/