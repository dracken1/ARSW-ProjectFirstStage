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

        Room sala1 = new Room(Salas.size());
        Salas.put(Salas.size(),sala1);

        Room sala2 = new Room(Salas.size());
        Salas.put(Salas.size(),sala2);
    }

    @Override
    public void addSala() throws ProjectException {
        Room nueva = new Room(Salas.size());
        Salas.put(Salas.size(),nueva);
        System.out.println(Salas.size());
    }

    public ConcurrentHashMap<Integer, Room> getSalas() {
        return Salas;
    }
}