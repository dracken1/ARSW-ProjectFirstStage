package com.bloody.app.bloodymoney.persistence.impl;

import com.bloody.app.bloodymoney.models.Sala;
import com.bloody.app.bloodymoney.persistence.SalasPersistence;
import com.bloody.app.bloodymoney.persistence.SalasPersistenceException;
import org.springframework.stereotype.Service;

@Service
public class InMemorySalaPersistence implements SalasPersistence{

    public InMemorySalaPersistence(){

    }

    @Override
    public void addSala(Sala s) throws SalasPersistenceException {

    }
}