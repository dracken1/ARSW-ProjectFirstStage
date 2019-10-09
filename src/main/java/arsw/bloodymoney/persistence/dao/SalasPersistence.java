
package arsw.bloodymoney.persistence.dao;

import com.bloody.app.bloodymoney.persistence.SalasPersistenceException;


import com.bloody.app.bloodymoney.models.Sala;
import org.springframework.stereotype.Service;

@Service
public interface SalasPersistence {


    public void addSala(Sala s) throws SalasPersistenceException;

}