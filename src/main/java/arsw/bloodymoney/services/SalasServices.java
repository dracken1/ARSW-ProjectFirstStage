
package arsw.bloodymoney.services;

import arsw.bloodymoney.entities.Room;
import arsw.bloodymoney.exceptions.SalasPersistenceException;
import arsw.bloodymoney.persistence.dao.SalasPersistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SalasServices{

    @Autowired
    SalasPersistence sp = null;

    public void addNewSala(Room r) throws SalasPersistenceException {

    }
}