package arsw.bloodymoney.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class Room that defines the
 * Rooms used by an User
 * @author Pedro Mayorga - PeNav
 * @version 1.0
 * @since 2019-09-23
 */
public class Room implements Serializable{
    
    private int idSala;
    private ArrayList<String> usuariosEnSala= new ArrayList<>();

    //Constructors
    public Room(int idSala) {
        this.idSala =  idSala;
    }

    public int getIdSala() {
        return idSala;
    }

    public ArrayList<String> getUsuariosEnSala() {
        return usuariosEnSala;
    }

    public void setUsuariosEnSala(ArrayList<String> usuariosEnSala) {
        this.usuariosEnSala = usuariosEnSala;
    }

    public void addUsuarios(String usuario){
        if(usuariosEnSala.size()<2){
            if(!usuariosEnSala.contains(usuario)){
                System.out.println("El usuario se unió a la sala...");
                usuariosEnSala.add(usuario);
            }else{
                System.out.println("El usuario ya se encuentra en la sala.");
            }

        }else{
            System.out.println("La sala está llena, lo sentimos! :(");
        }
        System.out.println(usuariosEnSala);


    }
}