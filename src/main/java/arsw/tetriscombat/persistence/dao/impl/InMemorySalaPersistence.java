package arsw.bloodymoney.persistence.dao.impl;

import arsw.bloodymoney.entities.Room;
import arsw.bloodymoney.exceptions.ProjectException;
import arsw.bloodymoney.persistence.dao.SalasPersistence;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
//import java.util.concurrent.ConcurrentHashMap;

@Service
public class InMemorySalaPersistence implements SalasPersistence{

    private ArrayList<Room> Salas= new ArrayList<>();

    public InMemorySalaPersistence(){

        Room sala1 = new Room(Salas.size());
        Salas.add(sala1);

        Room sala2 = new Room(Salas.size());
        Salas.add(sala2);
    }

    @Override
    public void addSala() throws ProjectException {
        Room nueva = new Room(Salas.size());
        Salas.add(nueva);
        System.out.println(Salas.size());
    }

    public ArrayList<Room> getSalas() {
        return Salas;
    }
}