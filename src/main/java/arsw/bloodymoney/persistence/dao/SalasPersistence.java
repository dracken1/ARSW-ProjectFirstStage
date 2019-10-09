
package arsw.bloodymoney.persistence.dao;

import arsw.bloodymoney.entities.Room;
import arsw.bloodymoney.exceptions.SalasPersistenceException;

import org.springframework.stereotype.Service;

@Service
public interface SalasPersistence {


    public void addSala(Room r) throws SalasPersistenceException;

}