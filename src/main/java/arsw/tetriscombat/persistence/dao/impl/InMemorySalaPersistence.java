package arsw.tetriscombat.persistence.dao.impl;

<<<<<<< HEAD:src/main/java/arsw/bloodymoney/persistence/dao/impl/InMemorySalaPersistence.java
import arsw.bloodymoney.entities.Room;
import arsw.bloodymoney.entities.User;
import arsw.bloodymoney.exceptions.ProjectException;
import arsw.bloodymoney.persistence.dao.SalasPersistence;
=======
import arsw.tetriscombat.entities.Room;
import arsw.tetriscombat.exceptions.ProjectException;
import arsw.tetriscombat.persistence.dao.SalasPersistence;
>>>>>>> bbf7e3a0fda9258fef3a2ef74a7319eea9fc3bb9:src/main/java/arsw/tetriscombat/persistence/dao/impl/InMemorySalaPersistence.java
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

    public void unirUsuarioASala(String username, int salaId){
        Salas.get(salaId).addUsuarios(username);
    }

    public ArrayList<Room> getSalas() {
        return Salas;
    }
}