package arsw.bloodymoney.persistence.dao;

import arsw.bloodymoney.entities.Room;
import arsw.bloodymoney.entities.User;
import java.util.List;

/**
 * Interface RoomDAO that defines all the
 * functionalities related with a Room
 * @author Pedro Mayorga
 * @version 1.0
 * @since 2019-09-20
 */
public interface RoomDAO {
    
    //Post
    public void save(Room room);
    
    //Get
    public Room load(int id);
    public Room load(String name);
    public List<Room> loadAll();
    
    //Put
    public void update(Room room);
    public void updateCapacity(int id, int newCapacity);
    
    //Delete
    public void delete(Room room);
    
}
