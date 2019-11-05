package arsw.bloodymoney.services.impl;

import arsw.bloodymoney.entities.Room;
import arsw.bloodymoney.exceptions.ProjectException;
import arsw.bloodymoney.persistence.dao.impl.InMemorySalaPersistence;
import arsw.bloodymoney.services.GameServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
//import java.util.concurrent.ConcurrentHashMap;
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
            arregloSalas.put(jo);
        }
        return arregloSalas;
    }
}
