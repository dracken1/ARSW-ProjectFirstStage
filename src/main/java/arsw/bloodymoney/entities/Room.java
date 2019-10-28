package arsw.bloodymoney.entities;

import java.io.Serializable;
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
    
    private String idSala;

    //Constructors
    public Room(String idSala) {
        this.idSala =  idSala;
    }
 
}