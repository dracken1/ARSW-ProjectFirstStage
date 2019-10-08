package com.bloody.app.bloodymoney.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.bloody.app.DBconnection.Bridge;
import com.bloody.app.bloodymoney.models.Sala;
import com.bloody.app.bloodymoney.services.SalasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Sala")

public class SalaController{
    @Autowired
    SalasServices salaServices = null;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addNewSala(@RequestBody Sala newSala){
        try {
            System.out.println("SALA");
        }catch (Exception ex){
            System.out.println("SALA");
        }
        return null;
    }




}