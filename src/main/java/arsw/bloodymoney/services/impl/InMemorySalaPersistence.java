package arsw.bloodymoney.services.impl;

import arsw.bloodymoney.entities.Room;
import arsw.bloodymoney.exceptions.SalasPersistenceException;
import arsw.bloodymoney.persistence.dao.SalasPersistence;
import org.springframework.stereotype.Service;

@Service
public class InMemorySalaPersistence implements SalasPersistence{

    public InMemorySalaPersistence(){

    }

    @Override
    public void addSala(Room r) throws SalasPersistenceException {
        
    }
}