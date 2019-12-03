package arsw.tetriscombat.controllers;

import arsw.tetriscombat.services.impl.SalasServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping(value = "/Sala")

public class SalaController{
    @Autowired
    SalasServicesImpl salasServices = new SalasServicesImpl();

    int numero = 10;
    @RequestMapping(method = RequestMethod.POST , path = "/add")
    public ResponseEntity<?> addNewSala(){
        try {
            salasServices.createElement(null);
            System.out.println("SALA CREADA");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            System.out.println("ERROR, NO SE HA CREADO LA SALA");
            Logger.getLogger(SalaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 403", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.GET , path = "/get")
    public ResponseEntity<?> getSalas(){
        try {
            return new ResponseEntity<>(salasServices.listaSalas().toString(),HttpStatus.OK);
        }catch (Exception ex){
            System.out.println("ERROR, NO SE HA ENCONTRADO LA SALA");
            Logger.getLogger(SalaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 404", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET , path = "/getById.{salaId}")
    public ResponseEntity<?> getSalaById(@PathVariable int salaId){
        try {
            return new ResponseEntity<>(salasServices.datosSala(salaId).toString(),HttpStatus.OK);
        }catch (Exception ex){
            System.out.println("ERROR, NO SE HA ENCONTRADO LA SALA");
            Logger.getLogger(SalaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 404", HttpStatus.NOT_FOUND);
        }
    }
}