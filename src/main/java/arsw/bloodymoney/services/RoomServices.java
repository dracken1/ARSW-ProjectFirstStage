package arsw.bloodymoney.services;

import arsw.bloodymoney.entities.Map;
import arsw.bloodymoney.entities.Room;
import arsw.bloodymoney.entities.User;
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
    
    public int getNumberOfUsers(int id);
    public void changeName(int id, String newName);
    public void changeCapacity(int id, String newCapacity);
    public void changeStages(int id, String newStages);
    public void banUser(int user_id);
    
    
    
    /*BASIC SERVICES*/
    
    //Add
    public void addRoom(String name, int capacity, int stages, int time);
    
    //Search
    public Room searchRoomByID(int id);
    public List<Room> searchRooms();
    public List<Map> searchMapsByRoom(int id);
    public List<User> searchUsersByRoom(int id);
    
    //Update
    public void updateRoom(int id, String name, int capacity, int stages, int time);
    
    //Delete
    public void deleteRoom(int id);
    
    //Status
    public boolean checkActiveStatus(int id);
    public void changeActiveStatus(int id, String newActiveStatus);
    public boolean checkFullStatus(int id);
    public void changeFullStatus(int id, String newFullStatus);
    
}
