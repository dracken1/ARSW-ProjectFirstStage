package arsw.bloodymoney.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Class Room that defines the
 * Rooms used by an User
 * @author Pedro Mayorga - PeNav
 * @version 1.0
 * @since 2019-09-23
 */
public class Room implements Serializable{
    
    private int id;
    private int capacity;
    private String remainingTime;
    private int rounds;
    
    private List<Map> maps;
    private List<User> users;
    
    //TimeinMinutes
    //long start = System.currentTimeMillis();
    //long elapsedTimeMillis = System.currentTimeMillis()-start;
    //float elapsedTimeMin = elapsedTimeMillis/(60*1000F);
    //float elapsedTimeSec = elapsedTimeMillis/1000F;
    
    private int idSala = 0;
    // el id se deberia crear automaticamente

    public Room(int idSala){
        this.idSala = idSala;
    }

    public int getIdSala() {
        return idSala;
    }
}