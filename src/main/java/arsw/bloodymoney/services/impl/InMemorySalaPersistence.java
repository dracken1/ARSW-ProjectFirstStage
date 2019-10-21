package arsw.bloodymoney.services.impl;

import arsw.bloodymoney.entities.Room;
import arsw.bloodymoney.exceptions.ProjectException;
import arsw.bloodymoney.persistence.dao.SalasPersistence;
import org.springframework.stereotype.Service;

@Service
public class InMemorySalaPersistence implements SalasPersistence{

    public InMemorySalaPersistence(){

    }

    @Override
    public void addSala(Room r) throws ProjectException {
        
    }
}