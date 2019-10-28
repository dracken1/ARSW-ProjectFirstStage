package arsw.bloodymoney.persistence.dao.impl;

import arsw.bloodymoney.entities.Room;
import arsw.bloodymoney.exceptions.ProjectException;
import arsw.bloodymoney.persistence.dao.SalasPersistence;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class InMemorySalaPersistence implements SalasPersistence{

    private ConcurrentHashMap<Integer,Room> Salas= new ConcurrentHashMap<>();

    public InMemorySalaPersistence(){

        Room sala1 = new Room("qwertyu");
        Salas.put(Salas.size(),sala1);

        Room sala2 = new Room("fsdfsd");
        Salas.put(Salas.size(),sala2);
    }

    @Override
    public void addSala(Room r) throws ProjectException {
        Salas.put(Salas.size(),r);
    }
}