package arsw.tetriscombat.persistence.dao.impl;


import arsw.tetriscombat.entities.Sala;
import arsw.tetriscombat.exceptions.ProjectException;
import arsw.tetriscombat.persistence.dao.SalasPersistence;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InMemorySalaPersistence implements SalasPersistence{
    private ArrayList<Sala> Salas= new ArrayList<>();

    public InMemorySalaPersistence(){
        Sala sala1 = new Sala(Salas.size());
        Salas.add(sala1);

        Sala sala2 = new Sala(Salas.size());
        Salas.add(sala2);
    }
    @Override
    public void addSala() throws ProjectException {
        Sala nueva = new Sala(Salas.size());
        Salas.add(nueva);
        System.out.println(Salas.size());
    }

    public void unirUsuarioASala(String username, int salaId){
        Salas.get(salaId).addUsuarios(username);
    }

    public ArrayList<Sala> getSalas() {
        return Salas;
    }

    public ArrayList<Sala> getSalaById(int salaId) {
        ArrayList<Sala> salaFake= new ArrayList<>();
        Sala salaSeleccionada = Salas.get(salaId);
        salaFake.add(salaSeleccionada);
        return salaFake;
    }

    public void abandonarSala(String username,int salaId){
        Salas.get(salaId).deleteUsuario(username);
    }
}