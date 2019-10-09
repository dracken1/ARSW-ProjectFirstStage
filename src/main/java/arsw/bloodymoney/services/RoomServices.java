package arsw.bloodymoney.services;

import arsw.bloodymoney.entities.Room;
import java.util.List;

/**
 * Interface RoomServices that defines all the
 * functionalities of the Rooms in the game
 * @author Pedro
 * @version 1.0
 * @since 2019-09-20
 */
public interface RoomServices {
    
    //TO-DO
    //Define functionalities of the rooms
    
    public int getNumberOfUsers(String id);
    
    
    
    /*BASIC SERVICES*/
    
    //Add
    public void addRoom();
    
    //Search
    public Room searchRoomByID(String id);
    public Room searchRoomByUser(String user_id);
    public Room searchRoomByMap(String map_id);
    public List<Room> searchRooms();
    
    //Update
    public void updateRoom(String id);
    
    //Delete
    public void deleteRoom(String id);
    
    //Status
    public boolean checkRoomStatus(String id);
    public void changeRoomStatus(String id, String newStatus);
    
}
