
package arsw.tetriscombat.persistence.dao;

//import arsw.bloodymoney.entities.Room;
import arsw.tetriscombat.exceptions.ProjectException;

import org.springframework.stereotype.Service;

@Service
public interface SalasPersistence {

    public void addSala() throws ProjectException;

}