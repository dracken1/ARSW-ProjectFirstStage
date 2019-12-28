package arsw.tetriscombat.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Sala implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private int idSala;
    private ArrayList<String> usuariosEnSala= new ArrayList<>();

    //Constructors
    public Sala(int idSala) {
        this.idSala =  idSala;
    }

    public int getIdSala() {
        return idSala;
    }

    public void deleteUsuario(String username){
        for(int i=0;i<usuariosEnSala.size();i++){
            if(usuariosEnSala.get(i).equals(username)){
                usuariosEnSala.remove(i);
            }
        }
    }

    public ArrayList<String> getUsuariosEnSala() {
        return usuariosEnSala;
    }

    //public void setUsuariosEnSala(ArrayList<String> usuariosEnSala) { this.usuariosEnSala = usuariosEnSala; }

    public void addUsuarios(String usuario){
        if(usuariosEnSala.size()<2){
            if(!usuariosEnSala.contains(usuario)){
                usuariosEnSala.add(usuario);
            }
        }
    }
}