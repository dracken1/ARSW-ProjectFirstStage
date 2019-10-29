package arsw.bloodymoney.controllers;

import arsw.bloodymoney.entities.Room;
import arsw.bloodymoney.services.impl.SalasServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Sala")

public class SalaController{
    @Autowired
    SalasServicesImpl salasServices = new SalasServicesImpl();

    @RequestMapping(method = RequestMethod.POST , path = "/add")
    public ResponseEntity<?> addNewSala(){
        try {
            salasServices.createElement(null);
            System.out.println("SALA CREADA");
        }catch (Exception ex){
            System.out.println("ERROR, NO SE HA CREADO LA SALA");
        }
        return null;
    }
}