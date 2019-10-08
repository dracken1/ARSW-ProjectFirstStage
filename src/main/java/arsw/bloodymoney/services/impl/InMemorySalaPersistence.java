package arsw.bloodymoney.services.impl;

import arsw.bloodymoney.entities.Room;
import arsw.bloodymoney.persistence.dao.SalasPersistence;

@Service
public class InMemorySalaPersistence implements SalasPersistence{

    public InMemorySalaPersistence(){

    }

    @Override
    public void addSala(Room s) throws SalasPersistenceException {
        
    }
}