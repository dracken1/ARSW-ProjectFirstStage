
<<<<<<< HEAD:src/main/java/com/bloody/app/bloodymoney/services/SalasServices.java
package com.bloody.app.bloodymoney.services;

import com.bloody.app.bloodymoney.models.Sala;
import com.bloody.app.bloodymoney.persistence.SalasPersistence;
import com.bloody.app.bloodymoney.persistence.SalasPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

=======
package arsw.bloodymoney.services;
>>>>>>> d1c7be56616376172c9e549f371e15c16b75ba8b:src/main/java/arsw/bloodymoney/services/SalasServices.java
@Service

public class SalasServices{

    @Autowired
    SalasPersistence sp = null;

    public void addNewSala(Sala s) throws SalasPersistenceException {

    }
}