package arsw.tetriscombat.services.impl;


import arsw.tetriscombat.entities.Room;
import arsw.tetriscombat.exceptions.ProjectException;
import arsw.tetriscombat.persistence.dao.impl.InMemorySalaPersistence;
import arsw.tetriscombat.services.GameServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;


@Service
public class SalasServicesImpl implements GameServices {

    InMemorySalaPersistence sp = new InMemorySalaPersistence();
    @Override
    public void createElement(Object elemento) throws ProjectException {
        sp.addSala();
    }
    @Override
    public Object Read() {
        return null;
    }

    @Override
    public Object Update() {
        return null;
    }

    @Override
    public void Delete() {

    }

    public JSONArray listaSalas(){
        JSONArray arregloSalas = new JSONArray();
        ArrayList <Room> salasGeneral = sp.getSalas();
        for(Object sala: salasGeneral){
            Room tempo = (Room) sala;
            JSONObject jo = new JSONObject();
            jo.append("descripcion",tempo.getIdSala());
            jo.append("cantidadJugadores",tempo.getUsuariosEnSala().size());
            arregloSalas.put(jo);
        }
        return arregloSalas;
    }

    public void unirUsuarioASala(String username, int salaId){
        sp.unirUsuarioASala(username,salaId);
    }
}
