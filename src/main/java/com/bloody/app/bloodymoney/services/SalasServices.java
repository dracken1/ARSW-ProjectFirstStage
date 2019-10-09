
package com.bloody.app.bloodymoney.services;

import com.bloody.app.bloodymoney.models.Sala;
import com.bloody.app.bloodymoney.persistence.SalasPersistence;
import com.bloody.app.bloodymoney.persistence.SalasPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class SalasServices{

    @Autowired
    SalasPersistence sp = null;

    public void addNewSala(Sala s) throws SalasPersistenceException {

    }
}