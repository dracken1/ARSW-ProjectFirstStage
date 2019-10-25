package arsw.bloodymoney.services.impl;

import arsw.bloodymoney.entities.Room;
import arsw.bloodymoney.exceptions.ProjectException;
import arsw.bloodymoney.persistence.dao.SalasPersistence;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class InMemorySalaPersistence implements SalasPersistence{

    private ConcurrentHashMap<String,Room> Salas= new ConcurrentHashMap<>();

    public InMemorySalaPersistence(){
    }

    @Override
    public void addSala(Room r) throws ProjectException {
        
    }
}